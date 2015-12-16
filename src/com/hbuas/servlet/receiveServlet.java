package com.hbuas.servlet;


import com.hbuas.picUpLoad.WeiXinPic;
import com.hbuas.pojo.Token;
import com.hbuas.picUpLoad.MediaUpload;
import com.hbuas.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bgm on 2015/11/26.
 */
@WebServlet(name = "ReciveServlet",urlPatterns = {"/receive"})
@MultipartConfig(fileSizeThreshold = 5242880,maxFileSize = 20971520L,maxRequestSize = 41943040L)

public class receiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        WeiXinPic weixinPic = null;

        Part part = request.getPart("pic");
        String picName = request.getParameter("picName");
        String picDescription = request.getParameter("picDescription");

        String appId = "wxddf3a1aaa9b9a02d";
        String appSecret = "d4624c36b6795d1d99dcf0547af5443d";

        Token token = CommonUtil.getToken(appId, appSecret);
        String accessToken = token.getAccessToken();
        String contentType = part.getContentType();
        InputStream inputStream = part.getInputStream();
        weixinPic = MediaUpload.uploadMedia(accessToken,contentType,inputStream);
        inputStream.close();

        weixinPic.setPicName(picName);
        weixinPic.setPicDescription(picDescription);
        request.setAttribute("data",weixinPic);
        request.getRequestDispatcher("/store").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
