/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.alumno;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import java.util.List;

/**
 *
 * @author Matias
 */
public interface IAlumnoService {

    public List<Alumno> buscarTodo();

    public Alumno buscarPorId(int id);

    public void save(Alumno alumno);
    
    public List<Alumno> buscarPorCurso(Curso curso);
    
    public List<Alumno> buscarPorDni(String dni, Curso curso);
    
    public void borrar(int id);
    

}
