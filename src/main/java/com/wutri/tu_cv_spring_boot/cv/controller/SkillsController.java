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

    @GetMapping("/id/{index}")
    public String showSkillDetail(@PathVariable int index, Model model) {
        if (index >= 0 && index < skills.size()) {
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);
            return "skill-detail";
        }
        return "redirect:/skills";
    }

    @GetMapping("/filter/{name}/{level}")
    public String showFilteredSkill(@PathVariable String name, @PathVariable String level, Model model) {
        List<Skill> skilsFilter = skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name)
                        && skill.getLevel().equalsIgnoreCase(level)
                )
                .toList();
        model.addAttribute("skills", skilsFilter);
        model.addAttribute("filterMessage", "Filtro : " + name + "- " + level);
        return "/skills";
    }

    @GetMapping("/name/{name}")
    public String showFilteredSkill(@PathVariable String name,  Model model) {
        List<Skill> skilsFilter = skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name))
                .toList();
        model.addAttribute("skills", skilsFilter);
        model.addAttribute("filterMessage", "Filtro : " + name);
        return "/skills";
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
