/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos;

import com.analistas.gestionAlumnos.gestionalumnos.auth.handler.LoginSuccesHandler;
import com.analistas.gestionAlumnos.gestionalumnos.services.usuario.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

;

/**
 *
 * @author matia
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JpaUserDetailsService userDateilsService;

    @Autowired
    private LoginSuccesHandler successHandler;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/vendor/**", "/scss/**", "/css/**", "/js/**", "/img/**").permitAll()
                // http.authorizeRequests().antMatchers("/").permitAll();

                /*.antMatchers("/").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                /*.antMatchers("/alumnos").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                /*.antMatchers("/materias").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                /*.antMatchers("/cursos").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                /*.antMatchers("/agendas").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                /*.antMatchers("/notas").hasAnyRole("ADMIN").anyRequest().authenticated()*/
                .anyRequest().authenticated()
                .and().formLogin()
                .successHandler(successHandler)
                .loginPage("/ingreso").permitAll().and().logout().permitAll();

    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

        build.userDetailsService(userDateilsService).passwordEncoder(passwordEncoder);

    }

}
