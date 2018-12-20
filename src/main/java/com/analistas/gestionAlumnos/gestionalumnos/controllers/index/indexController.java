/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.controllers.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author matia
 */

@Controller
public class indexController {
    
 
   
    @GetMapping({"/index"})
    public String indexController(Map m){
        
        
        
        return "/index";
    }
    
}


