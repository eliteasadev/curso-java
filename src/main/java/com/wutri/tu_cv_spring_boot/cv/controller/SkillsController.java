package com.wutri.tu_cv_spring_boot.cv.controller;

import com.wutri.tu_cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();

//    @GetMapping()
//    public String showSkills(Model model) {
//        model.addAttribute("skills", skills);
//        return "skills";
//    }

    @GetMapping()
    public String showSkills() {
        return "skills";
    }

    @ModelAttribute(name = "skills2")
    public List<Skill> getSkills() {
        return skills;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "add-skill";
    }

    @PostMapping("/add")
    public String addSkill(@ModelAttribute Skill skill) {
        skills.add(skill);
        return "redirect:/skills";
    }

}
