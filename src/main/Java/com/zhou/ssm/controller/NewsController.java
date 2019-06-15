package com.zhou.ssm.controller;
/**
 * Created by Administrator on 2017/4/6.
 */
import com.zhou.ssm.utils.Files_Helper;
import com.zhou.ssm.model.Tblnews;
import com.zhou.ssm.service.NewsService;
import com.zhou.ssm.service.UserService;
import com.zhou.ssm.utils.Files_Helper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.regex.*;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/news")
public class NewsController {
    private Logger log = Logger.getLogger(NewsController.class);
    @Resource
    private NewsService newsService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request, Model model) {
        log.info("查看所有新闻");
        try {
            List<Tblnews> newsList = newsService.getAll();
            model.addAttribute("newsList", newsList);
            return "VisitorNews";
        } catch (Exception ex) {
            log.info("Exception in getALLNews, ex: ", ex);
            return "fail";
        }
    }

    @RequestMapping("/getNews")
    public String getNews(HttpServletRequest request, Model model) {
        log.info("查看单击的新闻");
        try {
            String name = request.getParameter("newsid");
            int id = Integer.parseInt(name);
            Tblnews news = newsService.getNews(id);
            model.addAttribute("news", news);
            return "VisitorSpecificNews";
        } catch (Exception ex) {
            log.info("Exception in getNews, ex: ", ex);
            return "fail";
        }
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, Model model, HttpSession session) {
        log.info("管理员查看所有新闻");
        String error = null;
        try {
            if (session.getAttribute("adminname") == null) {
                return "login";
            }
            List<Tblnews> adminNewsList = newsService.getAll();
            model.addAttribute("adminNewsList", adminNewsList);
            return "AdminNews";
        } catch (Exception ex) {
            log.info("Exception in adminGetALLNews, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/adminGetNews")
    public String adminGetNews(HttpServletRequest request, Model model) {
        log.info("管理员查看单击的新闻");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            String name = request.getParameter("adminNewsid");
            int id = Integer.parseInt(name);
            Tblnews news = newsService.getNews(id);
            model.addAttribute("news", news);
            request.setAttribute("error", error);
            return "AdminSpecificNews";
        } catch (Exception ex) {
            log.info("Exception in AdminGetNews, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, Model model) {
        log.info("进入发布新闻页面");
        String error;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            return "AdminAddNews";
        } catch (Exception ex) {
            log.info("Exception in addNews, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/insert")
    public void insert(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("开始插入新闻数据");
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            Tblnews n = new Tblnews();

            String title = request.getParameter("title");
            String time = request.getParameter("time");
            log.info("标题！！！！" + title);
            log.info("时间！！！！" + time);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
            Date date = sdf.parse(time);

            n.setTitle(title);
            n.setNdate(date);
            n.setAuthor(adminname);

            String content = request.getParameter("newsContent");
            log.info("内容！！！！" + content);

            //解码
            Pattern pattern = Pattern.compile("data:image/(\\w+);base64,([a-z,A-Z,0-9,/,+,=]*)");
            Matcher matcher = pattern.matcher(content);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {      //找出base64图片元素
                String suffix = matcher.group(1);
                String src = matcher.group(2);
                String name = getRandomFileName();
                String realpath = Files_Helper.getAndSetAbsolutePath(request,"/newsImages",name,"."+suffix);
                String relativepath = Files_Helper.getRelativePath("/newsImages",name,"."+suffix);
                log.info("相对路径"+relativepath);
                convertBase64DataToImage(src,realpath);
                log.info("图片上传成功");
                matcher = matcher.appendReplacement(stringBuffer,".."+relativepath);
                log.info("一次替换"+stringBuffer.toString());
            }
            matcher.appendTail(stringBuffer);
            log.info("二次替换"+stringBuffer.toString());
            n.setNcontent(stringBuffer.toString());
            newsService.insert(n);

            response.setCharacterEncoding("utf-8");
            response.getWriter().write("{\"success\":true }");
            response.getWriter().flush();

        } catch (Exception ex) {
            log.info("Exception in insertNews, ex: ", ex);
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("删除新闻");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            String name = (String) request.getParameter("adminNewsid");
            int id = Integer.parseInt(name);
            newsService.delete(id);
            List<Tblnews> adminNewsList = newsService.getAll();
            model.addAttribute("adminNewsList", adminNewsList);
            return "AdminNews";
        } catch (Exception ex) {
            log.info("Exception in deleteNews, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    /**
     * 把base64图片数据转为本地图片
     *
     * @param base64ImgData
     * @param filePath
     * @throws IOException
     */
    public static void convertBase64DataToImage(String base64ImgData, String filePath) throws IOException {
        BASE64Decoder d = new BASE64Decoder();
        byte[] bs = d.decodeBuffer(base64ImgData);
        FileOutputStream os = new FileOutputStream(filePath);
        os.write(bs);
        os.close();

    }

    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;// 获取随机数
        return str + rannum;// 当前时间
    }

}