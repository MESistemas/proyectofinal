/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.auth.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

/**
 *
 * @author matia
 */
@Component
public class LoginSuccesHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
        
        FlashMap flashMap = new FlashMap();
        
        flashMap.put("success", "Has iniciado sesión con éxito");
        
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
        
        super.onAuthenticationSuccess(request, response, authentication); //To change body of generated methods, choose Tools | Templates.
    }
    
}
