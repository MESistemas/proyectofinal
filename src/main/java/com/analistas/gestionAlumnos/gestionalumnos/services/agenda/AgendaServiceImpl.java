/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.agenda;

import com.analistas.gestionalumnos.gestionalumnos.dao.agenda.IAgendaDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
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
public class AgendaServiceImpl implements IAgendaService{
    
    @Autowired
    IAgendaDao dao;

    @Override
     @Transactional(readOnly = true)
    public List<Agenda> buscarPorMateria(Materia materia){
        return dao.buscarPorMateria(materia);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Agenda buscarPorId(int id) {
        return dao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Agenda agenda) {
        dao.save(agenda);
    }
    
    @Override
    @Transactional
    public void borrar(int id) {
        dao.deleteById(id);
    }
    
}

