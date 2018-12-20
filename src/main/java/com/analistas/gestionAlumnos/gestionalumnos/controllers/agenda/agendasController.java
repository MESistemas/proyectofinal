/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.agenda;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.agenda.Agenda;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.services.agenda.IAgendaService;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Matias
 */
@Controller
@SessionAttributes("agenda")
public class agendasController {

    @Autowired
    IAgendaService servAgenda;

    private boolean datos_no_cargados;

    private boolean guardado = false;

    private boolean borrado = false;

    private Materia materia;

    @GetMapping("secciones/agendas/{materia}")
    public String agendaController(Map m, @PathVariable("materia") Materia materia) {

        this.materia = materia;

        List<Agenda> agenda = servAgenda.buscarPorMateria(materia);

        if (agenda.isEmpty()) {
            datos_no_cargados = true;
        } else {
            datos_no_cargados = false;
        }

        if (datos_no_cargados == true) {
            m.put("datos_no_cargados", datos_no_cargados);
        }

        m.put("materia", materia);
        m.put("agenda", agenda);
        m.put("curso", materia.getCurso());
        return "secciones/agendas";
    }

    //AGREGAR
    @GetMapping("secciones/formulario_agenda")
    public String Agregar_Agenda(Map m) {

        Agenda agenda = new Agenda();

        m.put("agenda", agenda);

        m.put("materia", materia);
        m.put("curso", materia.getCurso());

        m.put("body_titulo", "Agregar Agenda");
        return "secciones/formulario_agenda";
    }

    //EDITAR

    @GetMapping("/secciones/formulario_agenda/{id}")
    public String Editar_Agenda(@PathVariable(value = "id") int id, Map m) {
        Agenda agenda = new Agenda();
        agenda.setMateria(materia);
        agenda = servAgenda.buscarPorId(id);

        m.put("body_titulo", "Editar Agenda");
        m.put("agenda", agenda);
        m.put("materia", materia);
        m.put("curso", materia.getCurso());
        return "/secciones/formulario_agenda";
    }

    //GUARDAR

    @PostMapping("/secciones/formulario_agenda")
    public String Guardar_Agenda(@Valid Agenda agenda, Map m, RedirectAttributes flash) {
        m.put("materia", materia);

        agenda.setMateria(materia);
        servAgenda.save(agenda);

        guardado = true;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(agenda.getFecha());
        

        if (guardado) {
            flash.addFlashAttribute("guardado", "Se ha guardado con éxito '" + agenda.getTitulo() + "' el " + fecha);
        }

        return "redirect:/secciones/agendas/" + materia.getId();
    }

    //BORRAR
    
    @GetMapping("/secciones/formulario_agenda/borrar/{id}")
    public String Borrar_Agenda(@PathVariable(value = "id") int id, RedirectAttributes flash) {

        Agenda agenda = servAgenda.buscarPorId(id);
        
        servAgenda.borrar(id);
        
        borrado = true;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(agenda.getFecha());
        
        if (borrado) {
            flash.addFlashAttribute("borrado", "Se ha borrado con éxito '" + agenda.getTitulo() + " con fecha del " + fecha + "'");
        }

        return "redirect:/secciones/agendas/" + materia.getId();
    }

}
