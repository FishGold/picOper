package com.hbuas.servlet;

import com.hbuas.data.Insert;
import com.hbuas.picUpLoad.WeiXinPic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;

/**
 * Created by bgm on 2015/12/15.
 */
@WebServlet(name = "storeServlet",urlPatterns = {"/store"})
public class storeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WeiXinPic weixinPic = (WeiXinPic) request.getAttribute("data");
        String insertSQL = "Insert into perpic (name,description,url,time) values('"+weixinPic.getPicName()+"','"+weixinPic.getPicDescription()+"','"+weixinPic.getPicUrl()+"','"+new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss").format(new java.util.Date())+"')";
        ServletContext sc = request.getServletContext();
        Connection connection = (Connection)sc.getAttribute("connection");
        Insert insert = new Insert();
        boolean result;
        result = insert.Insert(insertSQL,connection);
        request.setAttribute("result",result);

        request.getRequestDispatcher("/JSP/Operate.jsp").forward(request,response);

    }
}
