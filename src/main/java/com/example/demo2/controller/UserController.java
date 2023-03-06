package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo2.domain.service.UserService;
import com.example.demo2.domain.model.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index(Model model){

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/index";
    }

    /**************
     * 新規登録
     ****************/
    @GetMapping("/create")
    public String createInput(){
        return "user/create";
    }

    @PostMapping("/create_confirm")
    public String createConfirm(@RequestParam("userName") String userName, @RequestParam("mailAddress") String mailAddress, Model model){

        model.addAttribute("userName", userName);
        model.addAttribute("mailAddress", mailAddress);

        return "user/createConfirm";
    }

    @PostMapping("/create_complete")
    public String createComplete(@RequestParam("userName") String userName, @RequestParam("mailAddress") String mailAddress){

        int count = userService.createUser(userName, mailAddress);
        System.out.println("ユーザー登録件数" + count + "件");
        return "redirect:/user";
    }


    /**************
     * 編集
    ****************/
    @GetMapping("/update/{id}")
    public String updateInput(@PathVariable int id, Model model){

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/update_confirm")
    public String updateConfirm(@RequestParam("userId") int id, @RequestParam("userName") String userName,
                                @RequestParam("mailAddress") String mailAddress, Model model){

        model.addAttribute("userId", id);
        model.addAttribute("userName", userName);
        model.addAttribute("mailAddress", mailAddress);
        return "user/updateConfirm";
    }

    @PostMapping("/update_complete")
    public String updateComplete(@RequestParam("userId") int id, @RequestParam("userName") String userName,
                                 @RequestParam("mailAddress") String mailAddress){

        int updatedUserId = userService.updateUser(id, userName, mailAddress);
        return "redirect:/user";
    }

    /*********************
     * 削除
     ******************/
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){

        System.out.println(id);

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/delete";
    }

    @PostMapping("/delete_complete")
    public String deleteComplete(@RequestParam("userId") int id){

        userService.deleteUser(id);
        return "redirect:/user";
    }


}
