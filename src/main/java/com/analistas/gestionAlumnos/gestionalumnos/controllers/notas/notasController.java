/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.controllers.notas;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import com.analistas.gestionalumnos.gestionalumnos.services.nota.INotaService;
import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author matia
 */

@Controller
@SessionAttributes("nota")
public class notasController {

    @Autowired
    INotaService servNota;

    private boolean datos_no_cargados = false;

    private boolean guardado = false;

    private boolean borrado = false;

    private Materia materia;
    private Alumno alumno;

    @GetMapping({"secciones/notas/{materia}/{alumno}"})
    public String detallesController(Map m, @PathVariable(value = "materia") Materia materia, @PathVariable(value = "alumno") Alumno alumno) {

        this.materia = materia;
        this.alumno = alumno;

        List<Nota> notas = servNota.buscarPorAlumnoyMateria(materia, alumno);

        if (notas.isEmpty()) {
            datos_no_cargados = true;
            m.put("datos_no_cargados", datos_no_cargados);
        }

        m.put("notas", notas);
        m.put("materia", materia);
        m.put("curso", alumno.getCurso());
        m.put("alu", alumno.getApellido() + ", " + alumno.getNombre());

        return "secciones/notas";
    }

    //AGREGAR
    @GetMapping("/secciones/formulario_notas")
    public String Agregar_Nota(Map m) {
        Nota nota = new Nota();

        m.put("nota", nota);
        m.put("body_titulo", "Agregar Nota");
        m.put("materia", materia);
        m.put("alumno", alumno);
        m.put("curso", alumno.getCurso());
        return "/secciones/formulario_notas";
    }

    //EDITAR
    @GetMapping("/secciones/formulario_notas/{id}")
    public String Editar_Nota(@PathVariable(value = "id") int id, Map m) {
        Nota nota = new Nota();

        nota = servNota.buscarPorId(id);

        m.put("nota", nota);
        m.put("body_titulo", "Editar Nota");
        m.put("materia", materia);
        m.put("alumno", alumno);
        m.put("curso", alumno.getCurso());
        return "/secciones/formulario_notas";
    }

    //GUARDAR
    @PostMapping("/secciones/formulario_notas")
    public String Guardar_Nota(@Valid Nota nota, RedirectAttributes flash) {

        nota.setMateria(materia);
        nota.setAlumno(alumno);

        servNota.save(nota);

        guardado = true;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(nota.getFecha());

        if (guardado) {
            flash.addFlashAttribute("guardado", "Se ha guardado con éxito nota del '" + nota.getDescripcion() + " con fecha del " + fecha + "'");
        }

        return "redirect:/secciones/notas/" + materia.getId() + "/" + alumno.getId();
    }

    //BORRAR
    @GetMapping("/secciones/formulario_notas/borrar/{id}")
    public String Borrar_Nota(@PathVariable(value = "id") int id, RedirectAttributes flash) {

        Nota nota = servNota.buscarPorId(id);

        servNota.borrar(id);

        borrado = true;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(nota.getFecha());

        if (borrado) {
            flash.addFlashAttribute("borrado", "Se ha borrado con éxito nota del '" + nota.getDescripcion() + " con fecha del " + fecha + "'");
        }

        return "redirect:/secciones/notas/" + materia.getId() + "/" + alumno.getId();
    }

}
