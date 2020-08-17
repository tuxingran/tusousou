package com.oracle.hrb.tusousou.controller;

import com.oracle.hrb.tusousou.pojo.Result;
import com.oracle.hrb.tusousou.pojo.User;
import com.oracle.hrb.tusousou.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

@RequestMapping("/user")
@RestController
public class UserController {

    public UserController() {
        System.out.println("启动了UserController");
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/add.do")
    public Result add(User user, HttpSession session, int yanzheng) {

        System.out.println(user);
        Result result = new Result();
        int yan = (Integer) session.getAttribute("yanzheng");
        System.out.println(yan);
        System.out.println(yanzheng);
        if (yan != yanzheng) {
            result.setOk(false);
            result.setMsg("1");
            return result;
        }
        int a = userService.add(user);
        if (a == 2) {
            result.setOk(false);
            result.setMsg("2");
            return result;
        }
        if (a == 3) {
            result.setMsg("3");
            result.setOk(false);
            return result;
        }

        return result;

    }

    @RequestMapping("/logout.do")
    public void logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        session.removeAttribute("user");
        session.invalidate();
        resp.sendRedirect("/tusousou/login.html");


    }


    @RequestMapping("/yanzheng.do")
    public Result yanzheng(HttpSession session, String path) {

        System.out.println(path);
        Random S1 = new Random();
        Result result = new Result();
        try {
            int yanzheng = 100000 + S1.nextInt(900000);
            userService.sendEmail(path, "兔飕飕欢迎您", "您的验证码是:" + yanzheng + "请不要泄露");
            System.out.println(yanzheng);
            session.setAttribute("yanzheng", yanzheng);
        } catch (Exception e) {
            result.setOk(false);
        }
        return result;


    }

    @RequestMapping("/login.do")
    public Result login(User user, HttpServletRequest req, HttpServletResponse resp, HttpSession session, String rememberMe) {
        String path = req.getContextPath();
        String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/";
        System.out.println(user);
        Result result = new Result();
        User u = userService.login(user);
        if (u == null) {
            result.setOk(false);
            return result;

        }

        if (rememberMe != null) {
            Cookie cookie = new Cookie("phone", user.getPhone());
            cookie.setPath(path);
            cookie.setMaxAge(Integer.parseInt(rememberMe));
            Cookie cookie2 = new Cookie("password", user.getPassword());
            cookie2.setPath(path);
            cookie2.setMaxAge(Integer.parseInt(rememberMe));
            resp.addCookie(cookie);
            resp.addCookie(cookie2);
        }
        System.out.println(path);
        System.out.println(basePath);
        session.setAttribute("user", u);
        return result;

    }

    @RequestMapping("/user.do")
    public Result user(HttpSession session) {

        Result result = new Result();
        Object obj = session.getAttribute("user");
        User user = (User) obj;
        int id = user.getId();
        result.addMap("user", userService.getUser(id));
        return result;


    }

    @RequestMapping("/update.do")
    public Result update(User user, HttpSession session) {
        Result result = new Result();
        User u = (User) session.getAttribute("user");
        Integer id = u.getId();
        user.setId(id);
        userService.update(user);
        return result;


    }

    @RequestMapping("/update2.do")
    public Result update2(User user, HttpSession session) {
        User u = (User) session.getAttribute("user");
        user.setId(u.getId());
        Result result = new Result();
        int i = userService.update2(user);
        if (i == 2) {
            result.setOk(false);
            result.setMsg("2");
            return result;
        }
        if (i == 3) {
            result.setOk(false);
            result.setMsg("3");
            return result;

        }
        return result;

    }

    @RequestMapping("/bring.do")
    public Result bring(HttpSession session, double money, String phone) {
        User user = new User();
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(money);
        money = Double.parseDouble(format);
        System.out.println(money);
        Result result = new Result();
        User u = (User) session.getAttribute("user");
        user.setMoney(money);
        user.setId(u.getId());
        int flag = userService.bring(user, phone);
        if (flag == 1) {
            result.setOk(false);
            result.setMsg("1");
            return result;
        }
        if (flag == 2) {
            result.setOk(false);
            result.setMsg("2");
            System.out.println("查无此人");
            return result;
        }
        System.out.println("哦企鹅啊我");
        return result;

    }

    @RequestMapping("/chongzhi.do")
    public Result chongzhi(HttpSession session, double money) {

        User user = new User();
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(money);
        money = Double.parseDouble(format);
        System.out.println(money);
        Result result = new Result();
        User u = (User) session.getAttribute("user");
        user.setMoney(money);
        user.setId(u.getId());
        userService.update(user);
        return result;

    }

    @RequestMapping("/invest.do")
    public Result invest(HttpSession session, double money, String password) {
        User user = new User();
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(money);
        money = Double.parseDouble(format);
        System.out.println(money);
        Result result = new Result();
        User u = (User) session.getAttribute("user");
        user.setMoney(money);
        user.setSouMoney((int) money / 2);
        user.setId(u.getId());
        System.out.println(money / 2);
        int flag = userService.invest(user, password);
        if (flag == 1) {
            result.setOk(false);
            result.setMsg("1");
            return result;
        }
        if (flag == 2) {
            result.setOk(false);
            result.setMsg("2");
            return result;
        }
        return result;

    }

    @RequestMapping("/touxiang.do")
    public void touxiang(HttpSession session, HttpServletResponse resp, RequestContext rc, HttpServletRequest req) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2.创建一个解析器
        ServletFileUpload sfu = new ServletFileUpload(factory);
        // 3.解析req
        try {
            List<FileItem> items = sfu.parseRequest(rc);
            // 4.遍历items
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // 普通表单域
                } else {
                    // 文件
                    // 获取上传的文件名
                    String name = item.getName();
                    String path = "img" + File.separator + System.currentTimeMillis() + "-" + name;
                    // 获取servlet上下文
                    ServletContext sc = req.getServletContext();
                    String realPath = sc.getRealPath(path);
                    System.out.println(realPath);
                    // 将文件存储到磁盘
                    File file = new File(realPath);
                    try {
                        item.write(file);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
