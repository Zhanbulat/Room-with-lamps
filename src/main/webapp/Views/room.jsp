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

    if(request.getServletContext().getAttribute(session.getAttribute("name")+"light")!=null&&request.getServletContext().getAttribute(session.getAttribute("name")+"light").equals("TRUE")){
    out.print("style='background-color:yellow';>");
}
    else{
        out.print(">");
    }
%>

<h1><%=session.getAttribute("name")%></h1>


<button onclick="location.href='/room?light=TRUE'">Включить свет</button>
</b>
<button onclick="location.href='/room?light=FALSE'">Выключить свет</button>
</b>
<div>
    <button onclick="location.href='/list'">Back to list</button>
</div>
</body>
</html>
