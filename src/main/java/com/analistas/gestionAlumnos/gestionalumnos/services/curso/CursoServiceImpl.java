/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.curso;

import com.analistas.gestionalumnos.gestionalumnos.dao.curso.ICursoDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Matias
 */
@Service
public class CursoServiceImpl implements ICursoService{
    
    @Autowired
    ICursoDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> buscarTodo() {
       return dao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Curso buscarPorId(int id) {
        return dao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Curso curso) {
        dao.save(curso);
    }
    
}
