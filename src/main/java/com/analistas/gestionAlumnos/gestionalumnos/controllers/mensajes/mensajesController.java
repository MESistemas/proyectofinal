/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.mensajes;

import com.analistas.gestionalumnos.gestionalumnos.services.mensajes.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Matias
 */

@Controller
public class mensajesController {

    @Autowired
    private MailService mailService;

   
    @GetMapping("/secciones/mensajes")
    public String mensajesController() {
        return "/secciones/mensajes";
    }

  
    @PostMapping("/secciones/mensajes")
    public String enviarCorreo(@RequestParam("contacto") String contacto, @RequestParam("correo") String correo, @RequestParam("asunto") String asunto, @RequestParam("mensaje") String mensaje) {

        String firma = mensaje + "\n\nAtte: MESistemas";
        mailService.enviarCorreo("matiasespindolads@gmail.com", correo, asunto, firma);

        return "/secciones/mensajes";
    }

}
