package com.example.springrecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","","/index","/index/"})
    String index(){
        return "index";
    }
}
