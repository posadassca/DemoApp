package com.ejemplo.demo.controller;

import com.ejemplo.demo.constant.ViewConstant;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

//    @GetMapping("/")
//    public String redirectToLogin(){
//        LOG.info("Method: " + "redirectToLogin()");
//        return "redirect:/login";
//    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name="error",required = false) String error,
                                @RequestParam(name="logout",required = false) String logout){
        LOG.info("Method: showLoginForm() -- Params: error = " + error + " , logout = "+ logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        LOG.info("Returning to LoginView");
        return ViewConstant.LOGIN;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck(){
        LOG.info("Method: loginCheck()");
//        LOG.info("Returning to LoginError");
        LOG.info("Returning to ShowContacts");
//        return "redirect:/login?error";
        return "redirect:/contacts/showcontacts";
    }


}
