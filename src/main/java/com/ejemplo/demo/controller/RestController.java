package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    /*
     * Al ser un método REST, no va a devolver un string, ni un ModelAndView. Va a responder un Json
     */
    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest(){
        ContactModel contactModel = new ContactModel(1, "Sebastian", "Posadas", "1145789865", "Buenos Aires");
        return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
    }

}
