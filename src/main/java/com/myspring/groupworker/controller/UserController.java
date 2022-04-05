package com.myspring.groupworker.controller;

import com.myspring.groupworker.model.Group;
import com.myspring.groupworker.model.User;
import com.myspring.groupworker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map<Integer, User> findAllWithCorrectGroupId(@PathVariable("groupId") int groupId, Model model){
        return userService.findByGroupId(groupId);
    }

    @GetMapping("/users-with-correct-id/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id, Model model){
        return userService.findById(id);
    }

    @GetMapping("/user-create")
    @ResponseBody
    public String createUserForm(User user){
        return "new-user-create";
    }

    @PostMapping("/new-user-create")
    public String createUser(User user){
        userService.saveNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveNewUser(user);
        return "redirect:/users";
    }
}
