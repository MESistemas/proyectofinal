/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.controllers.informes;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.materia.Materia;
import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import com.analistas.gestionalumnos.gestionalumnos.services.materia.IMateriaService;
import com.analistas.gestionalumnos.gestionalumnos.services.nota.INotaService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author matia
 */
@Controller
public class informesController {

    @Autowired
    private INotaService servNota;

    @Autowired
    private IMateriaService servMateria;

    @GetMapping("secciones/informes")
    public String seleccionarInforme(Map m) {

        List<Materia> materias = servMateria.buscarTodo();

        m.put("materias", materias);

        return "secciones/informes";
    }

    @PostMapping("secciones/informes/ver")
    public String verPorMateria(Map m, @RequestParam(name = "materia", required = false) Materia materia,
            @RequestParam(name = "examen", required = false) String descripcion) {

        List<Nota> listado = servNota.buscarPrimerExamenPorMateria(materia, descripcion);
        
        boolean no_cargados = false;
        
        if(listado.isEmpty()){
            no_cargados = true;
        }
        
        if(no_cargados == true){
            m.put("no_cargados", no_cargados);
        }else{
             m.put("no_cargados", no_cargados);
        }

        m.put("listado", listado);
        return "secciones/informes/ver";
    }

}
