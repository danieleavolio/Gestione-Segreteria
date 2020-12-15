package com.example.gestionesegreteria.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
    @GetMapping("/hello")     //  fa la get
    @ResponseBody // la risposta non è una pagina web, ma il corpo della response

    public String helloWorld() {
        return " <strong> Hello World </strong>";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


}
