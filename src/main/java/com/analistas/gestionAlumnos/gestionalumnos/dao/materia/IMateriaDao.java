/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.dao.materia;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Matias
 */
public interface IMateriaDao extends JpaRepository<Materia, Integer>{
    
    @Query("Select m from Materia m where m.curso = ?1")
    public List<Materia> buscarPorCurso(Curso curso);
    
}

