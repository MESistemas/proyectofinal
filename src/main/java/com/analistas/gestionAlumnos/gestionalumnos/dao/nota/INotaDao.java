/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.dao.nota;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author matia
 */
public interface INotaDao extends JpaRepository<Nota, Integer>{
    
   @Query("Select n from Nota n where n.materia = ?1 AND n.alumno = ?2 ORDER BY n.fecha")
   public List<Nota> buscarPorAlumnoyMateria(Materia materia, Alumno alumno);
   
   @Query("Select n from Nota n where n.materia = ?1 AND n.descripcion = ?2")
   public List<Nota> buscarPrimerExamenPorMateria(Materia materia, String descripcion);
    
}
