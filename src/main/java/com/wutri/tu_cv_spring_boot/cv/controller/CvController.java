package com.wutri.tu_cv_spring_boot.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cv", method = RequestMethod.GET)
public class CvController {

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    // @RequestMapping(value = "/pep", method = RequestMethod.GET)
    //@GetMapping({"/pep", "/", "/home"})
    @GetMapping("/pep")
    public String pep() {
        return "pep";
    }
}
