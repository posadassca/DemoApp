package com.ejemplo.demo.controller;

import com.ejemplo.demo.constant.ViewConstant;
import com.ejemplo.demo.model.ContactModel;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel(){
        LOG.info("Method: cancel() --> Controller: ContactController");
        return ViewConstant.CONTACTS;
    }


    @GetMapping("/contactform")
    public String redirectContactForm(Model model){
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
                                Model model){
        model.addAttribute("result", 1);
        LOG.info("Method: addContact()" + " -- Params: " + contactModel.toString());
        return ViewConstant.CONTACTS;
    }


}
