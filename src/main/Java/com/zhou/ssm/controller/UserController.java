package com.zhou.ssm.controller;

import com.zhou.ssm.model.Tbladmin;
import com.zhou.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model, HttpSession session) {
        log.info("查询所有管理员信息");
        String error = null;
        try {
            if (session.getAttribute("adminname") == null) {
                return "login";
            }
            List<Tbladmin> userList = userService.getAllUser();
            model.addAttribute("userList", userList);
            return "showUser";
        } catch (Exception ex) {
            log.info("Exception in getUsers, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        log.info("开始登陆");
        String error = null;
        error = "null";
        request.setAttribute("error",error);
        return "login";
    }

    @RequestMapping("/logincheck")
    public String logincheck(@RequestParam("ID") String username,
                             @RequestParam("PWD") String password,
                             HttpServletResponse response,
                             HttpServletRequest request,
                             Model model) {
        log.info("开始登陆验证");
        String error = null;
        try {
            if (userService.login(username, password).equals("success")) {
                request.getSession().setAttribute("adminname", username);
                int role = userService.getRole(username);
                request.getSession().setAttribute("adminRole", role);
                model.addAttribute("username", username);
                log.info("用户权限为"+role);
                if (role == 2) {
                    response.sendRedirect("../room/admin");
                }
                return "AdminMain";
            }
            else {
                error = "err";
                request.setAttribute("error",error);
                return "login";
            }
        } catch (Exception ex) {
            log.info("Exception in login, ex: ", ex);
            return "fail";
        }
    }

    @RequestMapping("/AdminMain")
    public String AdminMain(HttpServletRequest request, Model model) {
        log.info("管理员首页");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            return "AdminMain";
        } catch (Exception ex) {
            log.info("Exception in login, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam("userid") String userid,
                         @RequestParam("userpassword") String userpassword,
                         HttpServletRequest request,
                         Model model) {
        log.info("插入管理员");
        String error = null;
        try {
            Tbladmin a = new Tbladmin();
            a.setUserid(userid);
            a.setUserpassword(userpassword);
            a.setUserrole(2);
            userService.insert(a);
            List<Tbladmin> userList = userService.getAllUser();
            model.addAttribute("userList", userList);
            error = "success";
            request.setAttribute("error",error);
            return "login";
        }catch (Exception ex) {
            log.info("Exception in insert, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("删除组会通知");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            String id = request.getParameter("adminid");
            userService.delete(id);
            List<Tbladmin> userList = userService.getAllUser();
            model.addAttribute("userList", userList);
            return "showUser";
        } catch (Exception ex) {
            log.info("Exception in deleteUser, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

}
