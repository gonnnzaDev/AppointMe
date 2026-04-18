package com.gg.turnlook.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/hola")
    public String hola(){
        return "hola";
    }
}
