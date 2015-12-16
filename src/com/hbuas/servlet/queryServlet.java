package com.hbuas.servlet;

import com.hbuas.data.Query;
import com.hbuas.picUpLoad.WeiXinPic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bgm on 2015/12/15.
 */
@WebServlet(name = "queryServlet",urlPatterns = "/query")
public class queryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from perpic";
        ServletContext sc = request.getServletContext();
        Connection connection = (Connection)sc.getAttribute("connection");
        List<WeiXinPic> list = new ArrayList<WeiXinPic>();
        list = new Query().Query(sql,connection);
        request.setAttribute("Pics",list);
        request.getRequestDispatcher("/JSP/showInfo.jsp").forward(request,response);
    }
}
