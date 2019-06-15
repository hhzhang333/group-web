package com.zhou.ssm.controller;

/**
 * Created by Administrator on 2017/4/23.
 */
import com.zhou.ssm.utils.Files_Helper;
import com.zhou.ssm.model.Tblroom;
import com.zhou.ssm.service.RoomService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/room")
public class RoomController {
    private Logger log = Logger.getLogger(RoomController.class);
    @Resource
    private RoomService roomService;

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, Model model, HttpSession session) {
        log.info("管理员查看会议室预约");
        String error = null;
        try {
            if (session.getAttribute("adminname") == null) {
                return "login";
            }

            String adminname = request.getSession().getAttribute("adminname").toString();

            String selectdate =  request.getParameter("dateText");
            //String selectdate =  request.getParameter("time");
            String selectRoom =  request.getParameter("selectRoom");
            List<Tblroom> roomList1=new ArrayList<Tblroom>();
            log.info("日期："+selectdate);
            log.info("会议室："+selectRoom);
            //获得本周对应会议室预约时间表
            int day[][] = new int[7][14];
            String lender[][]= new String[7][14];
            for(int i=0;i<7;i++){
                for(int j=0;j<14;j++)
                    day[i][j]=0;
            }

            if(selectdate == null) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到本周日期
                java.util.Date date = new java.util.Date();
                Calendar cal = Calendar.getInstance();
                String seldate = sdf.format(date);
                cal.setTime(date);
                request.setAttribute("selectDateid", seldate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(lender[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
            }else {
                request.setAttribute("selectDateid", selectdate);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到选择日期
                java.util.Date selDate = sdf.parse(selectdate.toString());
                Calendar cal = Calendar.getInstance();
                cal.setTime(selDate);
                log.info("所选日期~~~~~："+selDate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(lender[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }

            }

                model.addAttribute("roomList1", roomList1);
                List<Tblroom> roomList2 = roomService.getRoom(adminname);
                List<Tblroom> before = new ArrayList<Tblroom>();//已完成预约
                List<Tblroom> after = new ArrayList<Tblroom>();//未完成预约
                Tblroom t;

                java.util.Date date2 = new java.util.Date();
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentdata = dateFormat.format(date2);
                java.util.Date currenttime = dateFormat.parse(currentdata);
                for (int i = 0; i < roomList2.size(); i++) {
                    t = roomList2.get(i);
                    if (currenttime.before(t.getEndtime())) {
                        after.add(t);
                    } else {
                        before.add(t);
                    }
                }
                model.addAttribute("before", before);
                model.addAttribute("after", after);
                return "Room";

        } catch (Exception ex) {
            log.info("Exception in adminGetRoom, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        log.info("删除预约");
        String error = null;
        try {
            String adminname = request.getSession().getAttribute("adminname").toString();
            String name = (String) request.getParameter("Roomid");
            int id = Integer.parseInt(name);
            roomService.delete(id);

            //重新遍历
            String selectdate =  request.getParameter("dateText");
            String selectRoom =  request.getParameter("selectRoom");
            List<Tblroom> roomList1=new ArrayList<Tblroom>();
            log.info("日期："+selectdate);
            log.info("会议室："+selectRoom);
            //获得本周对应会议室预约时间表
            int day[][] = new int[7][14];
            String lender[][]= new String[7][14];
            for(int i=0;i<7;i++){
                for(int j=0;j<14;j++)
                    day[i][j]=0;
            }

            if(selectdate == null) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到本周日期
                java.util.Date date = new java.util.Date();
                Calendar cal = Calendar.getInstance();
                String seldate = sdf.format(date);
                cal.setTime(date);
                request.setAttribute("selectDateid", seldate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
            }else {
                request.setAttribute("selectDateid", selectdate);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到选择日期
                java.util.Date selDate = sdf.parse(selectdate.toString());
                Calendar cal = Calendar.getInstance();
                cal.setTime(selDate);
                log.info("所选日期~~~~~："+selDate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }

            }

            model.addAttribute("roomList1", roomList1);
            List<Tblroom> roomList2 = roomService.getRoom(adminname);
            List<Tblroom> before = new ArrayList<Tblroom>();//已完成预约
            List<Tblroom> after = new ArrayList<Tblroom>();//未完成预约
            Tblroom t;

            java.util.Date date2 = new java.util.Date();
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentdata = dateFormat.format(date2);
            java.util.Date currenttime = dateFormat.parse(currentdata);
            for (int i = 0; i < roomList2.size(); i++) {
                t = roomList2.get(i);
                if (currenttime.before(t.getEndtime())) {
                    after.add(t);
                } else {
                    before.add(t);
                }
            }
            model.addAttribute("before", before);
            model.addAttribute("after", after);
            return "Room";
        } catch (Exception ex) {
            log.info("Exception in deleteROom, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam("time")String time,
                         @RequestParam("selectRoom2") String selectRoom2,
                         @RequestParam("select3") String select3,
                         @RequestParam("select4") String select4,
                         @RequestParam(value = "period", required = false) boolean period,
                         @RequestParam(value = "endTime", required = false) String endTime,
                         HttpServletRequest request,ModelMap model) {
        log.info("开始插入预约数据");
        String error = "";
        try {
            if (period) {
                List<Long> timeDurings = getAllDateDuring(time, endTime);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                for (Long during: timeDurings) {
                    cal.setTimeInMillis(during);
                    String realTime = simpleDateFormat.format(cal.getTime());
                    insertRoom(realTime, selectRoom2, select3, select4, error, request, model);
                }
            } else {
                insertRoom(time, selectRoom2, select3, select4, error, request, model);
            }
            return "Room";
        }catch (Exception ex) {
            log.info("Exception in insertRoom, ex: ", ex);
            log.info("管理员登陆失效，请重新登录");
            error = "lose";
            request.setAttribute("error", error);
            return "login";
        }
    }

    private List<Long> getAllDateDuring(String time, String endTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(time);
        Date endDate = simpleDateFormat.parse(endTime);
        long startMil = startDate.getTime();
        long endMil = endDate.getTime();

        List<Long> longList = new ArrayList<Long>();
        for (long i = endMil; i >= startMil; i -= 7 * 24 * 3600 * 1000) {
            longList.add(i);
        }
        return longList;
    }

    private void insertRoom(String time, String selectRoom2, String select3, String select4, String error,
                            HttpServletRequest request, ModelMap model) throws ParseException {
        String adminname = request.getSession().getAttribute("adminname").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date2 = sdf.parse(time);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        java.util.Date begin = sdf2.parse(time + " " + select3);
        java.util.Date end = sdf2.parse(time + " " + select4);
        int Roomid2 = Integer.parseInt(selectRoom2);

        int flag1[] = new int[14];//当天预约时间段
        int flag2[] = new int[14];//正在预约时间段
        //比较是否符合插入条件
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat dateFormat1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentdata1 = dateFormat1.format(date);
        java.util.Date currenttime = dateFormat1.parse(currentdata1);
        log.info("现在时间：" + currenttime);
        log.info("预约开始时间时间：" + begin);

        //当天的所有预约
        Tblroom today;
        int m = 0;
        int n = 0;
        boolean isRepeat = false;
        List<Tblroom> roomDate = roomService.getDate(date2, Roomid2);
        if (roomDate.size() != 0){
            for (int i = 0; i < roomDate.size(); i++) {
                today = roomDate.get(i);
                m = today.getBegintime().getHours();
                n = today.getEndtime().getHours();
                for (int k = m - 8; k < n-8; k++) {
                    flag1[k] = 1;
                }
            }
        }

        m = begin.getHours();
        n = end.getHours();
        for(int k = m-8;k<n-8;k++)
        {   flag2[k] = 1;}

        //比较时间段是否有冲突
        for(int i =0;i<14;i++){
            if(flag1[i] == 1 && flag2[i] ==1 )
            {
                isRepeat = true;
            }
        }

        if (currenttime.getTime()>begin.getTime()) {
            error = "over";
            request.setAttribute("error",error);
        }else if(end.getTime()<begin.getTime()){
            error = "fan";
            request.setAttribute("error",error);

        } else if(isRepeat == true){
            error = "repeat";
            request.setAttribute("error",error);
        }else
        {
            error = "success";
            request.setAttribute("error",error);
            //开始插入数据
            Tblroom td = new Tblroom();
            td.setRdate(date2);
            td.setRlender(adminname);
            td.setRoom(Roomid2);
            td.setBegintime(begin);
            td.setEndtime(end);
            roomService.insert(td);
        }


        //重新遍历
        String selectdate =  request.getParameter("dateText");
        String selectRoom =  request.getParameter("selectRoom");
        List<Tblroom> roomList1=new ArrayList<Tblroom>();
        log.info("日期："+selectdate);
        log.info("会议室："+selectRoom);
        //获得本周对应会议室预约时间表
        int day[][] = new int[7][14];
        String lender[][]= new String[7][14];
        for(int i=0;i<7;i++){
            for(int j=0;j<14;j++)
                day[i][j]=0;
        }

        if(selectdate == null) {
            Tblroom r;
            //得到本周日期
            Calendar cal = Calendar.getInstance();
            String seldate = sdf.format(date);
            cal.setTime(date);
            request.setAttribute("selectDateid", seldate);
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            // 获得当前日期是一个星期的第几天
            int nn = cal.get(Calendar.DAY_OF_WEEK);
            if (nn == 1) {
                nn = 7;
            } else {
                nn = nn - 1;
            }
            // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            int p, q;
            if (selectRoom != null) {
                request.setAttribute("selectRoomid", selectRoom);
                int Roomid = Integer.parseInt(selectRoom);
                for (int i = 1; i <= 7; i++) {
                    cal.add(Calendar.DATE, i - nn);
                    System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                    String s = sdf.format(cal.getTime());
                    java.util.Date SelectDate = sdf.parse(s);
                    roomList1 = roomService.getDate(SelectDate, Roomid);
                    if (roomList1.size() != 0) {
                        for (int j = 0; j < roomList1.size(); j++) {
                            r = roomList1.get(j);
                            p = r.getBegintime().getHours();
                            q = r.getEndtime().getHours();
                            for (int k = p - 8; k < q - 8; k++) {
                                day[i - 1][k] = 1;
                                lender[i-1][k] = r.getRlender();
                            }
                        }
                    }
                    cal.add(Calendar.DATE, nn - i);
                }
                request.setAttribute("day", day);
                request.setAttribute("lender", lender);
            } else {
                request.setAttribute("selectRoomid", 1);
                for (int i = 1; i <= 7; i++) {
                    cal.add(Calendar.DATE, i - nn);
                    System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                    String s = sdf.format(cal.getTime());
                    java.util.Date SelectDate = sdf.parse(s);
                    roomList1 = roomService.getDate(SelectDate, 1);
                    if (roomList1.size() != 0) {
                        for (int j = 0; j < roomList1.size(); j++) {
                            r = roomList1.get(j);
                            p = r.getBegintime().getHours();
                            q = r.getEndtime().getHours();
                            for (int k = p - 8; k < q - 8; k++) {
                                day[i - 1][k] = 1;
                                lender[i-1][k] = r.getRlender();
                                System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                            }
                        }
                    }
                    cal.add(Calendar.DATE, nn - i);
                }
                request.setAttribute("day", day);
                request.setAttribute("lender", lender);
            }

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 14; j++) {
                    System.out.print(day[i][j]);
                    System.out.print("    ");
                }
                System.out.print("\n");
            }
        }else {
            request.setAttribute("selectDateid", selectdate);
            Tblroom r;
            //得到选择日期
            java.util.Date selDate = sdf.parse(selectdate.toString());
            Calendar cal = Calendar.getInstance();
            cal.setTime(selDate);
            log.info("所选日期~~~~~："+selDate);
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            // 获得当前日期是一个星期的第几天
            int nn = cal.get(Calendar.DAY_OF_WEEK);
            if (nn == 1) {
                nn = 7;
            } else {
                nn = nn - 1;
            }
            // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            int p, q;
            if (selectRoom != null) {
                request.setAttribute("selectRoomid", selectRoom);
                int Roomid = Integer.parseInt(selectRoom);
                for (int i = 1; i <= 7; i++) {
                    cal.add(Calendar.DATE, i - nn);
                    System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                    String s = sdf.format(cal.getTime());
                    java.util.Date SelectDate = sdf.parse(s);
                    roomList1 = roomService.getDate(SelectDate, Roomid);
                    if (roomList1.size() != 0) {
                        for (int j = 0; j < roomList1.size(); j++) {
                            r = roomList1.get(j);
                            p = r.getBegintime().getHours();
                            q = r.getEndtime().getHours();
                            for (int k = p - 8; k < q - 8; k++) {
                                day[i - 1][k] = 1;
                                lender[i-1][k] = r.getRlender();
                            }
                        }
                    }
                    cal.add(Calendar.DATE, nn - i);
                }
                request.setAttribute("day", day);
                request.setAttribute("lender", lender);
            } else {
                request.setAttribute("selectRoomid", 1);
                for (int i = 1; i <= 7; i++) {
                    cal.add(Calendar.DATE, i - nn);
                    System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                    String s = sdf.format(cal.getTime());
                    java.util.Date SelectDate = sdf.parse(s);
                    roomList1 = roomService.getDate(SelectDate, 1);
                    if (roomList1.size() != 0) {
                        for (int j = 0; j < roomList1.size(); j++) {
                            r = roomList1.get(j);
                            p = r.getBegintime().getHours();
                            q = r.getEndtime().getHours();
                            for (int k = p - 8; k < q - 8; k++) {
                                day[i - 1][k] = 1;
                                lender[i-1][k] = r.getRlender();
                                System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                            }
                        }
                    }
                    cal.add(Calendar.DATE, nn - i);
                }
                request.setAttribute("day", day);
                request.setAttribute("lender", lender);
            }

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 14; j++) {
                    System.out.print(day[i][j]);
                    System.out.print("    ");
                }
                System.out.print("\n");
            }

        }

        model.addAttribute("roomList1", roomList1);
        List<Tblroom> roomList2 = roomService.getRoom(adminname);
        List<Tblroom> before = new ArrayList<Tblroom>();//已完成预约
        List<Tblroom> after = new ArrayList<Tblroom>();//未完成预约
        Tblroom t;

        java.util.Date date3 = new java.util.Date();
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentdata = dateFormat.format(date3);
        java.util.Date currenttime2 = dateFormat.parse(currentdata);
        for (int i = 0; i < roomList2.size(); i++) {
            t = roomList2.get(i);
            if (currenttime2.before(t.getEndtime())) {
                after.add(t);
            } else {
                before.add(t);
            }
        }

        model.addAttribute("before", before);
        model.addAttribute("after", after);
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request, Model model) {
        log.info("访客查看会议室预约");
        String error = null;
        try {
            String selectdate =  request.getParameter("dateText");
            //String selectdate =  request.getParameter("time");
            String selectRoom =  request.getParameter("selectRoom");
            List<Tblroom> roomList1=new ArrayList<Tblroom>();
            log.info("日期："+selectdate);
            log.info("会议室："+selectRoom);
            //获得本周对应会议室预约时间表
            int day[][] = new int[7][14];
            String lender[][]= new String[7][14];
            for(int i=0;i<7;i++){
                for(int j=0;j<14;j++)
                    day[i][j]=0;
            }

            if(selectdate == null) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到本周日期
                java.util.Date date = new java.util.Date();
                Calendar cal = Calendar.getInstance();
                String seldate = sdf.format(date);
                cal.setTime(date);
                request.setAttribute("selectDateid", seldate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(lender[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
            }else {
                request.setAttribute("selectDateid", selectdate);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Tblroom r;
                //得到选择日期
                java.util.Date selDate = sdf.parse(selectdate.toString());
                Calendar cal = Calendar.getInstance();
                cal.setTime(selDate);
                log.info("所选日期~~~~~："+selDate);
                int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (1 == dayWeek) {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
                // 获得当前日期是一个星期的第几天
                int n = cal.get(Calendar.DAY_OF_WEEK);
                if (n == 1) {
                    n = 7;
                } else {
                    n = n - 1;
                }
                // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
                int p, q;
                if (selectRoom != null) {
                    request.setAttribute("selectRoomid", selectRoom);
                    int Roomid = Integer.parseInt(selectRoom);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, Roomid);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                } else {
                    request.setAttribute("selectRoomid", 1);
                    for (int i = 1; i <= 7; i++) {
                        cal.add(Calendar.DATE, i - n);
                        System.out.println("本周第" + i + "天：" + sdf.format(cal.getTime()));
                        String s = sdf.format(cal.getTime());
                        java.util.Date SelectDate = sdf.parse(s);
                        roomList1 = roomService.getDate(SelectDate, 1);
                        if (roomList1.size() != 0) {
                            for (int j = 0; j < roomList1.size(); j++) {
                                r = roomList1.get(j);
                                p = r.getBegintime().getHours();
                                q = r.getEndtime().getHours();
                                for (int k = p - 8; k < q - 8; k++) {
                                    day[i - 1][k] = 1;
                                    lender[i-1][k] = r.getRlender();
                                    System.out.println("标记第" + i + "天第" + p + "到" + q + "时间段，数组day[" + (i - 1) + "][" + k + "]=1");
                                }
                            }
                        }
                        cal.add(Calendar.DATE, n - i);
                    }
                    request.setAttribute("day", day);
                    request.setAttribute("lender", lender);
                }

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(day[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 14; j++) {
                        System.out.print(lender[i][j]);
                        System.out.print("    ");
                    }
                    System.out.print("\n");
                }

            }

            return "VisitorRoom";

        } catch (Exception ex) {
            return "fail";
        }
    }

}
