/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.materias;

import com.analistas.gestionalumnos.gestionalumnos.dao.materia.IMateriaDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Matias
 */

@Controller
@SessionAttributes("materia")
public class materiasController {

    @Autowired
    IMateriaService servMateria;

    private boolean centrar_elemento;
    private boolean no_centrar_elemento;

    @GetMapping({"secciones/materias/{curso}"})
    public String elegirMateria(@PathVariable(value = "curso") Curso curso, Map m) {

        centrar_elemento = false;
        no_centrar_elemento = false;

        List<Materia> listarMaterias = servMateria.buscarPorCurso(curso);

        if (listarMaterias.size() == 1) {
            centrar_elemento = true;
            no_centrar_elemento = false;
        } else if (listarMaterias.size() > 1) {
            no_centrar_elemento = true;
            centrar_elemento = false;
        }

        if (centrar_elemento) {
            m.put("centrar_elemento", centrar_elemento);
        }

        if (no_centrar_elemento) {
            m.put("no_centrar_elemento", no_centrar_elemento);
        }

        m.put("curso", curso);
        m.put("materias", listarMaterias);
        return "secciones/materias";
    }

    //EDITAR
    @GetMapping("/secciones/formulario_materia/{id}")
    public String Editar_Materia(@PathVariable(value = "id") int id, Map m) {
        Materia materia = new Materia();
        materia = servMateria.buscarPorId(id);

        m.put("materia", materia);
        m.put("body_titulo", "Editar Materia");

        return "secciones/formulario_materia";
    }

    //GUARDAR
    @PostMapping("/secciones/formulario_materia")
    public String Guardar_Materia(@Valid Materia materia, BindingResult result) {

        servMateria.save(materia);

        return "redirect:/secciones/materias/" + materia.getId();
    }

}
