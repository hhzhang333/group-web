package com.zhou.ssm.controller;

/**
 * Created by Administrator on 2017/4/14.
 */
import com.zhou.ssm.utils.Files_Helper;
import com.zhou.ssm.model.Tblpaper;
import com.zhou.ssm.service.PaperService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/paper")
public class PaperController {
    private Logger log = Logger.getLogger(PaperController.class);
    @Resource
    private PaperService paperService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request, Model model) {
        log.info("查看所有论文");
        try {
            String ref = "Allempty";
            List<Tblpaper> paperList = paperService.getAll();
            model.addAttribute("paperList", paperList);
            request.getSession().setAttribute("refe", ref);
            return "VisitorPaper";
        } catch (Exception ex) {
            log.info("Exception in getALLPaper, ex: ", ex);
            return "fail";
        }
    }


    @RequestMapping("/getReference")
    public void getReference(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("引用论文");
        String ref="notEmpty";
        try {
            List<Tblpaper> paperList = paperService.getAll();
            String name = request.getParameter("adminPaperid");
            int id = Integer.parseInt(name);
            Tblpaper r;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");//小写的mm表示的是分钟
            if (paperList.size() != 0) {
                for (int j = 0; j < paperList.size(); j++) {
                    r = paperList.get(j);
                    if(r.getId() == id){
                        int year = r.getPdate().getYear()+1900;
                        ref= r.getAuthor()+"."+r.getTitle()+"."+r.getPgroup()+","+year+":"+r.getPpages();
                        log.info(ref);
                        request.getSession().setAttribute("refe", ref);
                    }
                }
            }
            log.info("执行了没"+request.getSession().getAttribute("refe"));
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(ref);
            response.getWriter().flush();
        } catch (Exception ex) {
            log.info("Exception in getRef, ex: ", ex);
        }
    }

    @RequestMapping("/getYear")
    public String getYear(HttpServletRequest request, Model model) {
        try {
            String ref = "empty";
            List<Tblpaper> paperListAll = paperService.getAll();
            List<Tblpaper> paperList = new ArrayList<Tblpaper>();
            String name = request.getParameter("year");
            log.info("查看"+name+"年论文");
            int year = Integer.parseInt(name);
            Tblpaper r;
            if (paperListAll.size() != 0) {
                for (int j = 0; j < paperListAll.size(); j++) {
                    r = paperListAll.get(j);
                    int b = r.getPdate().getYear()+1900;
                    if(b == year){
                        paperList.add(r);
                        log.info(r.getTitle());
                    }

                }
            }
            model.addAttribute("paperList", paperList);
            request.getSession().setAttribute("refe", ref);
            return "VisitorPaper";
        } catch (Exception ex) {
            log.info("Exception in getYearPaper, ex: ", ex);
            return "fail";
        }
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, Model model, HttpSession session) {
        log.info("管理员查看所有论文");
        String error = null;
        try {
            if (session.getAttribute("adminname") == null) {
                return "login";
            }
            List<Tblpaper> paperList = paperService.getAll();
            model.addAttribute("paperList", paperList);
            return "AdminPaper";
        } catch (Exception ex) {
            log.info("Exception in adminGetALLPaper, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam("time")String time,@RequestParam("title") String title, @RequestParam("author") String author,@RequestParam("page") String page, @RequestParam("book") String book,@RequestParam("upPDF") MultipartFile upPDF,HttpServletRequest request,Model model) {
        log.info("开始插入论文数据");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
            java.util.Date date=sdf.parse(time);
            Tblpaper t = new Tblpaper();
            t.setPdate(date);
            t.setTitle(title);
            t.setAuthor(author);
            t.setPpages(page);
            t.setPgroup(book);
            String pdf = Files_Helper.FilesUpload_stream(request,upPDF,title,"/files");
            log.info("PDF上传成功");
            t.setPname(pdf);
            paperService.insert(t);
            List<Tblpaper> paperList = paperService.getAll();
            model.addAttribute("paperList", paperList);
            error = "success";
            request.setAttribute("error",error);
            return "AdminPaper";
        }catch (Exception ex) {
            log.info("Exception in insertPaper, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("删除论文");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            String name = (String)request.getParameter("adminPaperid");
            int id = Integer.parseInt(name);
            paperService.delete(id);
            List<Tblpaper> paperList = paperService.getAll();
            model.addAttribute("paperList", paperList);
            return "AdminPaper";
        } catch (Exception ex) {
            log.info("Exception in deletePaper, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping(value = "fileDownload_pdf")
    public void fileDownload_pdf(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("开始PDF下载");
            String name = request.getParameter("Paperid");
            int id = Integer.parseInt(name);
            Tblpaper t = paperService.getPaper(id);
            String path = t.getPname();
            Files_Helper.FilesDownload_stream(request,response,path);
        } catch (Exception ex) {
            log.info("Exception in DownPDF, ex: ", ex);
        }
    }
}
