package com.ejemplo.demo.controller;

import com.ejemplo.demo.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping("/contactform")
    public String redirectContactForm(){
        return ViewConstant.CONTACT_FORM;
    }

}
