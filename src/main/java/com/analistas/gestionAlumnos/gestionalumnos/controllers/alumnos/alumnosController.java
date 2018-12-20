/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.alumnos;

import com.analistas.gestionalumnos.gestionalumnos.dao.alumno.IAlumnoDao;
import com.analistas.gestionalumnos.gestionalumnos.dao.nota.INotaDao;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.alumno.Alumno;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.curso.Curso;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import com.analistas.gestionalumnos.gestionalumnos.services.alumno.IAlumnoService;
import com.analistas.gestionalumnos.gestionalumnos.services.curso.ICursoService;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import com.analistas.gestionalumnos.gestionalumnos.services.nota.INotaService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author matia
 */

@Controller
@SessionAttributes("alumno")
public class alumnosController {

    @Autowired
    IAlumnoService servAlumno;

    @Autowired
    INotaService servNota;

    private Curso curso;
    private Materia materia;
    private Alumno alumno;

    private boolean datos_no_cargados;

    private boolean guardado = false;

    private boolean borrado = false;

    private static boolean repetido = false;

   
    @GetMapping("secciones/alumnos/{curso}/{materia}")
    public String listarAlumnos(@PathVariable(value = "curso") Curso curso, @PathVariable(value = "materia") Materia materia, Map m) {

        this.curso = curso;

        this.materia = materia;

        List<Alumno> listarAlumnos = servAlumno.buscarPorCurso(curso);

        if (listarAlumnos.isEmpty()) {
            datos_no_cargados = true;
            m.put("datos_no_cargados", datos_no_cargados);
        }

        m.put("nom_materia", materia.getNombre_Materia());
        m.put("curso", this.curso);
        m.put("alumnos", listarAlumnos);
        m.put("materia", materia.getId());
        return "secciones/alumnos";
    }

    //AGREGAR
    
    @GetMapping("/secciones/formulario_alumno")
    public String Agregar_Alumno(Map m, @RequestParam(name = "genero", required = false) String genero, RedirectAttributes flash) {

        Alumno alumno = new Alumno();

        this.alumno = alumno;

       
        m.put("alumno", alumno);
        m.put("materia", materia.getId());
        m.put("curso", curso);
        m.put("body_titulo", "Agregar Alumno");

        return "/secciones/formulario_alumno";

    }

    //EDITAR
    
    @GetMapping("/secciones/formulario_alumno/{id}")
    public String Editar_Alumno(@PathVariable(value = "id") int id, Map m) {

        Alumno alumno = new Alumno();

        alumno = servAlumno.buscarPorId(id);

        m.put("materia", materia.getId());

        m.put("alumno", alumno);
        m.put("curso", curso);
        m.put("body_titulo", "Editar Alumno");

        return "secciones/formulario_alumno";
    }

    //GUARDAR
    
    @PostMapping("/secciones/formulario_alumno")
    public String Guardar_Alumno(@Valid Alumno alumno, Map m, RedirectAttributes flash, BindingResult result) {

        //Cuando se valida el alumno se le asigna el Curso
        alumno.setCurso(curso);

        try {

            servAlumno.save(alumno);
            guardado = true;

            if (guardado) {
                flash.addFlashAttribute("guardado", "Se ha guardado con éxito a " + alumno.getNombre() + ", " + alumno.getApellido() + " de DNI " + alumno.getDni());
            }

            return "redirect:/secciones/alumnos/" + curso.getId() + "/" + materia.getId();

        } catch (Exception e) {

                
            
                flash.addFlashAttribute("error", "¡El alumno ya existe!");
            

        }

        return "redirect:/secciones/formulario_alumno";

    }

    //BORRAR
   
    @GetMapping("/secciones/formulario_alumno/borrar/{id}")
    public String Borrar_Alumno(@PathVariable(value = "id") int id, RedirectAttributes flash) {

        Alumno alumno = servAlumno.buscarPorId(id);

        servAlumno.borrar(id);
        borrado = true;

        if (borrado) {
            flash.addFlashAttribute("borrado", "Se ha borrado con éxito a '" + alumno.getApellido() + ", " + alumno.getNombre() + " de DNI " + alumno.getDni() + "'");
        }

        return "redirect:/secciones/alumnos/" + curso.getId() + "/" + materia.getId();
    }

}
