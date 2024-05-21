package com.sending.mails.services;

import com.sending.mails.services.models.DataDTO;
import com.sending.mails.services.models.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailServices {
    public void sendMail(EmailDTO email) throws MessagingException;

    public void sendData(DataDTO email) throws MessagingException;

    public void sendRegister(EmailDTO email) throws MessagingException;

}
