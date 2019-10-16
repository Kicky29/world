package com.tcsoft.world.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminPageController {

    @GetMapping("/admin")
    public String admin(){
        return "redirect:admin_user_list";
    }

    @GetMapping("/admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }
}
