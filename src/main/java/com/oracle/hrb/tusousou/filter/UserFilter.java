package com.oracle.hrb.tusousou.filter;

import com.oracle.hrb.tusousou.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class UserFilter implements Filter {

    public UserFilter() {
        System.out.println("NoteFilter启动了+++++++++++++++++++++++++++++");
    }

    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        list.add("/login.do");
        list.add("/add.do");
        list.add("/open.do");
        list.add("/login.html");
        list.add("/registe.html");
        list.add("/index.html");
        list.add("/yanzheng.do");


    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        String path2 = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path2 + "/";
        if (list.contains(path) || path.endsWith("css") || path.endsWith("js") || path.endsWith("jpg") || path.endsWith("png") || path.endsWith("gif")) {

            filterChain.doFilter(request, response);
            return;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(basePath + "login.html");
            return;
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
