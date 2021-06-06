<%@ page import="jakarta.servlet.ServletContext" %><%--
  Created by IntelliJ IDEA.
  User: zhani
  Date: 05.06.2021
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body
<%

    if(request.getServletContext().getAttribute(session.getAttribute("name")+"light")!=null&&request.getServletContext().getAttribute(session.getAttribute("name")+"light").equals("onn")){
    out.print("style='background-color:yellow';>");
}
    else{
        out.print(">");
    }
%>

<h1><%=session.getAttribute("name")%></h1>
<button onclick="location.href='/room?light=onn'">Включить свет</button>
<button onclick="location.href='/room?light=off'">Выключить свет</button>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
