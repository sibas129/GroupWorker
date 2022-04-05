package com.myspring.groupworker.controller;

import com.myspring.groupworker.model.Group;
import com.myspring.groupworker.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GroupController {
    private final GroupService GroupService;

    @Autowired
    public GroupController(GroupService GroupService) {
        this.GroupService = GroupService;
    }

    @GetMapping("/groups")
    @ResponseBody
    public Map<Integer, Group> findAll(){
        return GroupService.findAll();
    }

    @GetMapping("/groups-with-correct-id/{id}")
    @ResponseBody
    public Group findById(@PathVariable("id") int id, Model model){
       return GroupService.findById(id);
    }

    @GetMapping("group-delete/{id}")
    public String deleteGroup(@PathVariable("id") int id){
        GroupService.deleteById(id);

        return "redirect:/groups";
    }
}
