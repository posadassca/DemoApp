package com.ejemplo.demo.controller;

import com.ejemplo.demo.constant.ViewConstant;
import com.ejemplo.demo.model.UserCredential;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin(){
        LOG.info("Method: " + "redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name="error",required = false) String error,
                                @RequestParam(name="logout",required = false) String logout){
        LOG.info("Method: showLoginForm() -- Params: error = " + error + " , logout = "+ logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("userCredentials", new UserCredential());
        LOG.info("Returning to LoginView");
        return ViewConstant.LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials")UserCredential userCredential){
        LOG.info("Method: loginCheck() -- Params: " + userCredential.toString());
        if("user".equals(userCredential.getUserName()) && "user".equals(userCredential.getPassword())){
            LOG.info("Returning to ContactView");
            return ViewConstant.CONTACTS;
        }
        LOG.info("Returning to LoginError");
        return "redirect:/login?error";
    }


}
