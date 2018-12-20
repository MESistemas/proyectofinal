/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.login;

import java.security.Principal;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Matias
 */
@Controller
public class loginController {

    @GetMapping({"/ingreso"})
    public String loginController(
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "error", required = false) String error,
            Model m, Principal principal,  @RequestParam(value = "flash", required = false) String flash) {

        if (principal != null) {
            m.addAttribute("flash", "¡Ya has iniciado sesión!");
            return "redirect:/";
        }

        if (error != null) {
            m.addAttribute("error", "Credenciales incorrectas");
        }
        
        if (logout != null) {
            m.addAttribute("logout", "¡Has cerrado sesión con éxito!");
        }


        return "ingreso";
    }

}
