package com.wutri.tu_cv_spring_boot.cv.controller;

import com.wutri.tu_cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model) {
        List<Skill> skilsFilter = skills.stream()
                        .filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase()))
                                .toList();
        model.addAttribute("skills", skilsFilter);
        model.addAttribute("filter", filter);
        return "skills";
    }

//    @GetMapping()
//    public String showSkills() {
//        return "skills";
//    }

    @ModelAttribute(name = "skills2")
    public List<Skill> getSkills() {
        return skills;
    }

    @GetMapping("/{index}")
    public String showSkillDetail(@PathVariable int index, Model model){
        if(index >= 0 && index < skills.size()){
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);
            return "skill-detail";
        }
        return "redirect:/skills";
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
