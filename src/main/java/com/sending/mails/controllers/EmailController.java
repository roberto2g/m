package com.sending.mails.controllers;

import com.sending.mails.services.IEmailServices;
import com.sending.mails.services.impl.EmailServicesImpl;
import com.sending.mails.services.models.DataDTO;
import com.sending.mails.services.models.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Collections;

@RestController
@RequestMapping
public class EmailController {

    //Utilizo la Interfaz para implementar el EmailService
    @Autowired
    IEmailServices iEmailServices;
    //Llega el mail al controlador
    @PostMapping(value = "/sendEmail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> sendEmail(@RequestBody EmailDTO email) throws MessagingException {
        //Utilizamos la implementacion de interface IEmailServices
        iEmailServices.sendMail(email);
        //return new ResponseEntity<>("Correo enviado exitosamente.", HttpStatus.OK);
        return new ResponseEntity<>(Collections.singletonMap("message", "Correo enviado exitosamente."), HttpStatus.OK);

    }
    @PostMapping(value="/sendData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> sendData(@RequestBody DataDTO email) throws MessagingException {
        //Utilizamos la implementacion de interface IEmailServices
        iEmailServices.sendData(email);
        return new ResponseEntity<>(Collections.singletonMap("message", "Correo enviado exitosamente."), HttpStatus.OK);
    }

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> sendRegister(@RequestBody EmailDTO email) throws MessagingException {
        //Utilizamos la implementacion de interface IEmailServices
        iEmailServices.sendRegister(email);
        return new ResponseEntity<>(Collections.singletonMap("message", "Correo enviado exitosamente."), HttpStatus.OK);
    }
}
