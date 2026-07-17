package com.wutri.tu_cv_spring_boot.cv.controller;

import com.wutri.tu_cv_spring_boot.cv.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/cv", method = RequestMethod.GET)
public class CvController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        Person person = new Person("Gabriel", "Moy", "Desarrollador Web");
        model.addAttribute("name", "Ga");
        model.addAttribute("person", person);
        return "index";
    }

//    @GetMapping({"/index", "/", "/home"})
//    public String index(Map<String, Object> model) {
//        model.put("name", "Gabriel");
//        return "index";
//    }

    // @RequestMapping(value = "/pep", method = RequestMethod.GET)
    //@GetMapping({"/pep", "/", "/home"})
    //@GetMapping("/pep")
//    public String pep() {
//        return "pep";
//    }
}
