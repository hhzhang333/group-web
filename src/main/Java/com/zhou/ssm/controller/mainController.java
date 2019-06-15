package com.zhou.ssm.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/5.
 */
@Controller
public class mainController {
    private Logger log = Logger.getLogger(mainController.class);

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpSession session) {
        log.info("访客首页");
        session.removeAttribute("adminname");
        return "VisitorMain";
    }


}
