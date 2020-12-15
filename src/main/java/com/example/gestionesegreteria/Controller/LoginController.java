package com.example.gestionesegreteria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("doLogin")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (loginOk(username, password)) {
            session.setAttribute("usernameLogged", username );
            //return "loginSuccess";
            return "index";
        }
        else
            return "loginError";

    }

    @GetMapping ("doLogout")
    public String logout (HttpSession session){
        session.invalidate();
        return "logoutSuccess";
    }
    private boolean loginOk(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
