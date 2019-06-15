package com.zhou.ssm.controller;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.utils.Files_Helper;
import com.zhou.ssm.model.Tblgroup;
import com.zhou.ssm.service.GroupService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/group")
public class GroupController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private GroupService groupService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request,Model model) {
        log.info("查看所有组会通知");
        try {
            List<Tblgroup> groupList = groupService.getAll();
            model.addAttribute("groupList", groupList);
            return "VisitorGroup";
        } catch (Exception ex) {
            log.info("Exception in getALLGroup, ex: ", ex);
            return "fail";
        }
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, Model model, HttpSession session) {
        log.info("管理员查看所有组会通知");
        String error = null;
        try {
            if (session.getAttribute("adminname") == null) {
                return "login";
            }
            List<Tblgroup> groupList = groupService.getAll();
            model.addAttribute("groupList", groupList);
            return "AdminGroup";
        } catch (Exception ex) {
            log.info("Exception in getALLGroup, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }
    @RequestMapping("/insert")
    public String insert(@RequestParam("time")String time,
                         @RequestParam("place") String place,
                         @RequestParam("speaker") String speaker,
                         @RequestParam("topic") String topic,
                         @RequestParam("upPPT") MultipartFile upPPT,
                         @RequestParam("upPDF") MultipartFile upPDF,
                         @RequestParam("referencePDF") MultipartFile referencePDF,
                         @RequestParam("conference") String conference,
                         HttpServletRequest request,
                         Model model) {
        log.info("开始插入通知数据");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
            java.util.Date date=sdf.parse(time);
            Tblgroup g = new Tblgroup();
            g.setGdate(date);
            g.setGspace(place);
            g.setGspeaker(speaker);
            g.setGtopic(topic);
            g.setConference(conference);

            String ppt = Files_Helper.FilesUpload_stream(request,upPPT,topic,"/files");
            log.info("PPT上传成功");
            g.setPpt(ppt);
            String pdf = Files_Helper.FilesUpload_stream(request,upPDF,topic,"/files");
            log.info("PDF上传成功");
            g.setPdf(pdf);

            String referencepdf = Files_Helper.FilesUpload_stream(request, referencePDF, topic + "reference", "/files");
            log.info("参考文献上传成功");
            g.setReferencePDF(referencepdf);
            groupService.insert(g);
            List<Tblgroup> groupList = groupService.getAll();
            model.addAttribute("groupList", groupList);
            error = "success";
            request.setAttribute("error",error);
            return "AdminGroup";
        }catch (Exception ex) {
            log.info("Exception in insertGroup, ex: ", ex);
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
            String name = (String)request.getParameter("adminGroupid");
            int id = Integer.parseInt(name);
            groupService.delete(id);
            List<Tblgroup> groupList = groupService.getAll();
            model.addAttribute("groupList", groupList);
            return "AdminGroup";
        } catch (Exception ex) {
            log.info("Exception in deleteGroup, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    /**
     文件下载
     */
    @RequestMapping(value = "fileDownload_ppt")
    public void fileDownload_ppt(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("开始PPT下载");
            String name = request.getParameter("Groupid");
            int id = Integer.parseInt(name);
            Tblgroup group = groupService.getGroup(id);
            String path = group.getPpt();
            Files_Helper.FilesDownload_stream(request,response,path);
        } catch (Exception ex) {
            log.info("Exception in DownPPT, ex: ", ex);
        }

    }

    @RequestMapping(value = "fileDownload_pdf")
    public void fileDownload_pdf(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("开始PDF下载");
            String name = request.getParameter("Groupid");
            int id = Integer.parseInt(name);
            Tblgroup group = groupService.getGroup(id);
            String path = group.getPdf();
            Files_Helper.FilesDownload_stream(request,response,path);
        } catch (Exception ex) {
            log.info("Exception in DownPDF, ex: ", ex);
        }
    }

    @RequestMapping(value = "fileDownload_reference")
    public void fileDownload_reference(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("开始reference_PDF下载");
            String name = request.getParameter("Groupid");
            int id = Integer.parseInt(name);
            Tblgroup group = groupService.getGroup(id);
            String path = group.getReferencePDF();
            Files_Helper.FilesDownload_stream(request,response,path);
        } catch (Exception ex) {
            log.info("Exception in DownPDF, ex: ", ex);
        }
    }

    /*
    @RequestMapping(value = "view_pdf")
    public String view_pdf(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("开始PDF在线查看");
            String error = null;
            String name = request.getParameter("Groupid");
            int id = Integer.parseInt(name);
            Tblgroup group = groupService.getGroup(id);
            String relativepath = group.getPdf();
            String realPath = Files_Helper.getServerPath(request,relativepath);
            error = "打开";
            request.setAttribute("error",error);
            request.setAttribute("realPath",realPath);
            return "VisitorGroup";
        } catch (Exception ex) {
            log.info("Exception in DownPDF, ex: ", ex);
            return "fail";
        }
    }*/

}
