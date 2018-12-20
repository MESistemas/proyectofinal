/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.agenda;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import java.util.List;

/**
 *
 * @author Matias
 */
public interface IAgendaService {

    public List<Agenda> buscarPorMateria(Materia materia);
    
    public void save(Agenda agenda);
    
    public Agenda buscarPorId(int id);
    
    public void borrar(int id);

}

