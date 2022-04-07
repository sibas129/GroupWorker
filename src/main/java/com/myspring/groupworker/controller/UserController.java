package com.myspring.groupworker.controller;

import com.myspring.groupworker.model.User;
import com.myspring.groupworker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public Map<Integer, User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users-with-correct-groupId/{groupId}")
    @ResponseBody
    public Map<Integer, User> findAllWithCorrectGroupId(@PathVariable("groupId") int groupId){
        return userService.findByGroupId(groupId);
    }

    @GetMapping("/users-with-correct-id/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user, Integer id){
        userService.saveOldUser(id, user);
        return "redirect:/users";
    }
}
