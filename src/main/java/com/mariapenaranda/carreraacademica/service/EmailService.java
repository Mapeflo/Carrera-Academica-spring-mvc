package com.mariapenaranda.carreraacademica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarClave(String para, String nombre, String clave) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(para);
        mensaje.setSubject("Recuperación de clave - Carrera Académica");
        mensaje.setText("Hola " + nombre + ",\n\nTu clave de acceso es: " + clave + "\n\nSaludos.");

        mailSender.send(mensaje);
    }
}