/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.materia;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import java.util.List;

/**
 *
 * @author Matias
 */
public interface IMateriaService {
    
    public List<Materia> buscarTodo();

    public Materia buscarPorId(int id);

    public void save(Materia materia);
    
    public List<Materia> buscarPorCurso(Curso curso);
    
}