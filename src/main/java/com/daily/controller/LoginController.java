package com.daily.controller;

import com.daily.model.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("success.do")
    public String success(ModelMap model) {
        return "index";
    }

    @RequestMapping("login.do")
    public String login(User user, HttpServletRequest req, ModelMap model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        String error = "";
        try
        {
            subject.login(token);
        } catch (UnknownAccountException e)
        {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e)
        {
            error = "用户名/密码错误";
        } catch (LockedAccountException e)
        {
            error = "登录账户被锁";
        } catch (ExcessiveAttemptsException e)
        {
            error = "密码输入错误超过5次，请30分钟后再登录";
        } catch (Exception e)
        {
            error = "请登录";
        }
        if (StringUtils.isNotEmpty(error))
        {
            model.addAttribute("error", error);
            return "login";
        }
        return "redirect:success.do";
    }

    @RequestMapping("logout.do")
    public String logout(){
        return "login";
    }
}
