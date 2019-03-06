package com.netease.salessystem.controller;

import com.netease.salessystem.common.JsonResult;
import com.netease.salessystem.domain.User;
import com.netease.salessystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final String ONLINE_USER = "online_user";

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestParam("username") String userName, @RequestParam("password") String passWord, HttpServletRequest request) {
        User user = userService.find(userName, passWord);
        HttpSession session = request.getSession();
        session.setAttribute(ONLINE_USER, user.getUserName());
        return JsonResult.create().addResult(user);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(ONLINE_USER);
        return JsonResult.create();
    }
}
