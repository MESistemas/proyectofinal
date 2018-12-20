/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.dao.usuario;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.usuario.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author matia
 */
public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

    public Usuario findByUsername(String username);

}
