/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.curso;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import java.util.List;

/**
 *
 * @author Matias
 */
public interface ICursoService {

    public List<Curso> buscarTodo();

    public Curso buscarPorId(int id);

    public void save(Curso curso);

}

