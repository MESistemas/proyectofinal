/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.nota;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import java.util.List;

/**
 *
 * @author matia
 */
public interface INotaService {

    public List<Nota> buscarTodo();

    public Nota buscarPorId(int id);

    public void save(Nota nota);

    public void borrar(int id);

    public List<Nota> buscarPorAlumnoyMateria(Materia materia, Alumno alumno);

    public List<Nota> buscarPrimerExamenPorMateria(Materia materia, String descripcion);

}
