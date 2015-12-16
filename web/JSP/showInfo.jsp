<%--
  Created by IntelliJ IDEA.
  User: bgm
  Date: 2015/12/15
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>已经上传的图片的信息</title>
    <style>
      table{
          border-collapse: collapse;
          text-align: left;
          border: 1px solid blue;
      }
      table a{
          text-decoration: none;
      }
      th{
            border-spacing: 2px;
            border: 1px solid green;
            padding: 5px;
        }
    </style>
</head>
<body>
     <table>
       <thead>
           <tr>
              <th>ID</th>
              <th>名字</th>
              <th>描述</th>
              <th>URL</th>
              <th>上传日期</th>
           </tr>
       </thead>
       <tbody>
          <c:forEach items="${Pics}" var="Pics">
              <tr>
                <th>${Pics.getID()}</th>
                <th>${Pics.getPicName()}</th>
                <th>${Pics.getPicDescription()}</th>
                <th><a href="${Pics.getPicUrl()}">${Pics.getPicUrl()}</a></th>
                <th>${Pics.getDate()}</th>
              </tr>
          </c:forEach>
       </tbody>
     </table>
</body>
</html>
