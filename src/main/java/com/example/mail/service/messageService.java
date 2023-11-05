package com.example.mail.service;

import com.example.mail.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class messageService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getReceiver());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getMessage());


        javaMailSender.send(simpleMailMessage);
    }
}
