package com.myspring.groupworker.controller;

import com.myspring.groupworker.model.Group;
import com.myspring.groupworker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class GroupController {
    private final GroupService GroupService;

    @Autowired
    public GroupController(GroupService GroupService) {
        this.GroupService = GroupService;
    }

    @GetMapping("/groups")
    public String findAll(Model model){
        model.addAttribute("groups", GroupService.findAll());

        return "/groups";
    }

    @GetMapping("/groups-with-correct-id/{id}")
    public String findById(@PathVariable("id") int id, Model model){
        model.addAttribute("Groups", GroupService.findById(id));

        return "groups";
    }

    @GetMapping("group-delete/{id}")
    public String deleteGroup(@PathVariable("id") int id){
        GroupService.deleteById(id);
        return "redirect:/groups";
    }
}
