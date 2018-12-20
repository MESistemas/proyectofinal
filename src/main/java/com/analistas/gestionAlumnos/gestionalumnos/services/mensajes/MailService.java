/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionalumnos.gestionalumnos.services.mensajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matias
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarCorreo(String de, String para, String asunto, String mensaje) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(de);
        email.setTo(para);
        email.setSubject(asunto);
        email.setText(mensaje);

        javaMailSender.send(email);
    }
}