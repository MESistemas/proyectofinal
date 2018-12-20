/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.dao.curso;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Matias
 */
public interface ICursoDao extends JpaRepository<Curso, Integer> {
    
}
