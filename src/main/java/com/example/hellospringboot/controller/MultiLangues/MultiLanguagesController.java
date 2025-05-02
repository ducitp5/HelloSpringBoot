package com.example.hellospringboot.controller.MultiLangues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Controller
@RequestMapping("multi_languages")
public class MultiLanguagesController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        var message = messageSource.getMessage("hello", null, locale);
        return message;
    }

    @GetMapping("/home")
    public String home() {
        return "multi_languages/switch_languages"; // returns home.html
    }
}
