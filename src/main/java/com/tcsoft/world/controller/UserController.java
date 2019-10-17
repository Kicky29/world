package com.tcsoft.world.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tcsoft.world.pojo.User;
import com.tcsoft.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public PageInfo<User> list(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<User> us = userService.list();
        PageInfo<User> page = new PageInfo<>(us, 5); //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") int id) throws Exception {
        System.out.println(id);
        User u = userService.get(id);
        return u;
    }

    @PostMapping("/users")
    public String add(@RequestBody User u) throws Exception {
        userService.add(u);
        return "success";
    }

    @DeleteMapping("/users/{id}")
    public String delete(User u) throws Exception {
        userService.delete(u.getId());
        return "success";
    }

    @PutMapping("/users/{id}")
    public String update(@RequestBody User u) throws Exception {
        userService.update(u);
        return "success";
    }

    /*页面跳转 部分*/
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView listUser() {
        ModelAndView mv = new ModelAndView("listUser");
        return mv;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser() {
        ModelAndView mv = new ModelAndView("editUser");
        return mv;
    }
}
