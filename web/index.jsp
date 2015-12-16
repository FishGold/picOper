<%--
  Created by IntelliJ IDEA.
  User: bgm
  Date: 2015/12/15
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>上传永久图片素材</title>
  </head>
  <body>
       <form action="/receive"method="post"enctype="multipart/form-data" style="margin: auto">
         <blockquote>
           <label>选择图片</label>
           <input type="file"name="pic"><br><br>
           <label>输入名字</label>
           <input type="text"name="picName"><br><br>
           <label>输入描述</label>
           <input type="text"name="picDescription">
         </blockquote>
         <blockquote>
           <input type="submit"value="上传">
           <input type="reset"value="取消">
         </blockquote>
       </form>
      <blockquote>
        <a href="/query">查看已经上传的图片</a>
      </blockquote>
  </body>
</html>
