/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.services.usuario;

import com.analistas.gestionAlumnos.gestionalumnos.dao.usuario.IUsuarioDao;
import com.analistas.gestionAlumnos.gestionalumnos.models.entitys.roles.Rol;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author matia
 */
@Service("jpaUserDatilsService")
public class JpaUserDetailsService implements UserDetailsService {
    
    @Autowired
    private IUsuarioDao dao;
    
    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = dao.findByUsername(username);
        
        if (usuario == null) {
            logger.error("Error login: no existe el usuario");
            throw new UsernameNotFoundException(username + ": no existe el usuario");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            logger.info("Role: ".concat(rol.getAuthority()));
            authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
        }
        
        if (authorities.isEmpty()) {
            logger.error("Error login: no tiene roles");
            throw new UsernameNotFoundException(username + "no tiene roles");
        }
        
        return new User(usuario.getUsername(), usuario.getPass(), usuario.getEnabled(), true,
                true, true, authorities);        
    }
    
}
