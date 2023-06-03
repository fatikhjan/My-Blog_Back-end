package com.aditya.emailservice.controller;

import com.aditya.emailservice.domain.Mails;
import com.aditya.emailservice.dto.MessageDTO;
import com.aditya.emailservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {


    public final MessageService messageService;

    @PostMapping("api/sendMessage")
    public String sendMessage(@RequestBody MessageDTO message) {
        Mails mail = new Mails();
        mail.setMailFrom(message.getSender());
        mail.setMailTo("muhammad2004fotih@gmail.com");
        mail.setMailSubject("Message From " + message.getFullName());
        mail.setMailContent(message.getMessage()+" \n Message From "+ message.getSender());
        messageService.sendEmail(mail);
        return "ok";
    }

}
