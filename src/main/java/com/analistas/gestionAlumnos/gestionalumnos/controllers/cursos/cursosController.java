/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.cursos;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.services.curso.ICursoService;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Matias
 */

@Controller
@SessionAttributes("curso")
public class cursosController {

    /* CURSO */
    @Autowired
    ICursoService servCurso;

    private boolean centrar_elemento;
    private boolean no_centrar_elemento;

   
    @GetMapping({"secciones/cursos"})
    public String elegirCurso(Map m) {

        List<Curso> listarCursos = servCurso.buscarTodo();

        if (listarCursos.size() == 1) {
            centrar_elemento = true;
            no_centrar_elemento = false;
        } else if (listarCursos.size() > 1) {
            no_centrar_elemento = true;
            centrar_elemento = false;
        }

        if (centrar_elemento) {
            m.put("centrar_elemento", centrar_elemento);
        }

        if (no_centrar_elemento) {
            m.put("no_centrar_elemento", no_centrar_elemento);
        }

        m.put("cursos", listarCursos);
        return "secciones/cursos";
    }

    //EDITAR
   
    @GetMapping({"/secciones/formulario_curso/{id}"})
    public String Editar_Curso(@PathVariable(value = "id") int id, Map m) {

        Curso curso = new Curso();
        curso = servCurso.buscarPorId(id);

        m.put("curso", curso);
        m.put("division", curso.getDivision());
        m.put("titulo_body", "Modificar Curso");

        return "secciones/formulario_curso";
    }

    //GUARDAR
   
    @PostMapping("/secciones/formulario_curso")
    public String Guardar_Curso(@Valid Curso curso) {

        servCurso.save(curso);

        return "redirect:/secciones/cursos";
    }

}
