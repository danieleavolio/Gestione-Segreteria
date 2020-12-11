package com.example.gestionesegreteria.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class Hello {
    @GetMapping("/hello")     //  fa la get
    @ResponseBody // la risposta non è una pagina web, ma il corpo della response

    public String helloWorld(){
        return " <strong>Hello World </strong>";
    }


    @GetMapping({"/ciao"})
    public String hello (Model model, @RequestParam(value="name", required = false, defaultValue = "JSP") String name ) {
        model.addAttribute("name", name);
        model.addAttribute("time", new Date());
        model.addAttribute("message","hello");

        return "ciaoView";
    }
}
