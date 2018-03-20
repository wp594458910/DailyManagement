package com.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Creator : peng
 * Date : 2018-03-19
 * Time : 14:25
 */
@Controller
public class LoginController {

    @RequestMapping("admin.do")
    public String admin() {
        return "login";
    }

    @RequestMapping("login.do")
    public String login(String username, String password, ModelMap model) {
        if (username.equals("admin") && password.equals("feastcoding")) {
            return "index";
        } else {
            model.put("mes", "用户名或密码错误");
            return "login";
        }
    }
}
