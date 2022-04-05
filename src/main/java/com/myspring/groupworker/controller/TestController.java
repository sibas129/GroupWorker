package com.myspring.groupworker.controller;

import com.myspring.groupworker.model.Group;
import com.myspring.groupworker.model.User;
import com.myspring.groupworker.service.GroupService;
import com.myspring.groupworker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    private final UserService userService;
    private final GroupService groupService;

    @Autowired
    public TestController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping("get-user-dto")
    @ResponseBody
    public Map<String, String> getUser(){
        Map<String, String> usersDto = new HashMap<>();

        for(Map.Entry<Integer, User> item : userService.findAll().entrySet()){
            Group group = groupService.findById(item.getValue().getGroupId());
            usersDto.put(item.getValue().getName(), group.getName());
        }

        return usersDto;
    }
}
