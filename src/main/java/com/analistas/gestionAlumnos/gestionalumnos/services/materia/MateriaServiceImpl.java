/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.materia;

import com.analistas.gestionalumnos.gestionalumnos.dao.materia.IMateriaDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias
 */
@Service
public class MateriaServiceImpl implements IMateriaService {
    
    @Autowired
    IMateriaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Materia> buscarTodo() {
       return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Materia buscarPorId(int id) {
       return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Materia materia) {
        dao.save(materia);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Materia> buscarPorCurso(Curso curso) {
        return dao.buscarPorCurso(curso);
    }
    
}
