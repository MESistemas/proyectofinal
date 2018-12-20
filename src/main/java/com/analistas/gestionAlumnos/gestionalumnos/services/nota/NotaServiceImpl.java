/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.nota;

import com.analistas.gestionalumnos.gestionalumnos.dao.nota.INotaDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author matia
 */
@Service
public class NotaServiceImpl implements INotaService {

    @Autowired
    INotaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Nota> buscarTodo() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Nota buscarPorId(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Nota nota) {
        dao.save(nota);
    }

    @Override
    @Transactional
    public void borrar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nota> buscarPorAlumnoyMateria(Materia materia, Alumno alumno) {
        return dao.buscarPorAlumnoyMateria(materia, alumno);
    }

    @Override
    public List<Nota> buscarPrimerExamenPorMateria(Materia materia, String descripcion) {
        return dao.buscarPrimerExamenPorMateria(materia, descripcion);
    }

}
