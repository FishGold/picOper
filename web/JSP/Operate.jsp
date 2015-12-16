<%--
  Created by IntelliJ IDEA.
  User: bgm
  Date: 2015/12/15
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>上传结果</title>
</head>
<body>
   <c:if test="${!result}" var="condition" scope="session">
     上传失败，请点击<a href="/index.jsp">重新上传</a>
   </c:if>
   <c:if test="${result}" var="condition" scope="session">
     上传成功，请点击<a href="/index.jsp">重新上传</a>
     或者点击<a href="/query">已上传的图片</a>
   </c:if>
</body>
</html>
