package com.dudusam.mini.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/test")
@Controller
public class TestController {

    @RequestMapping(value = "/1")
    public ResponseEntity test(){
        return ResponseEntity.ok("success");
    }
}
