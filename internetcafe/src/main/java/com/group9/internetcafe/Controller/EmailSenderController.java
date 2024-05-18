package com.group9.internetcafe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group9.internetcafe.Service.EmailSenderService;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailSenderController {
	@Autowired
	EmailSenderService emailServ;
	
	@PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String toEmail, @RequestParam String body) {
        emailServ.sendEmail(toEmail, body);
        return "Mail Sent Successfully ^^";
    }
}
