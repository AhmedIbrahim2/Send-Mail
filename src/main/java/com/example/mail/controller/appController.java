package com.example.mail.controller;


import com.example.mail.model.Email;
import com.example.mail.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class appController {


    @Autowired
    messageService messageServices;

    @RequestMapping("/sendEmail")
    public String sendEmailForm(Model model){
            model.addAttribute("email", new Email());


        return "/emailForm";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute Email email){
        for (int i = 0 ; i< 10 ; i++) {
            messageServices.sendMessage(email);
        }
        return "/emailSend";
    }
}
