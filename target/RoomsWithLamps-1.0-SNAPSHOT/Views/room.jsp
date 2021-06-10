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
    <title>Inside the room</title>
    <link href="Views/css/style.css" rel="stylesheet" type="text/css">
</head>
<body
<%

    if(request.getServletContext().getAttribute(session.getAttribute("name")+"light")!=null&&request.getServletContext().getAttribute(session.getAttribute("name")+"light").equals("TRUE")){
    out.print("style='background-color:yellow'>");
}
    else{
        out.print(">");
    }
%>
<div class="home">
<h1 style="font-size: xxx-large" class="home-text"><%=session.getAttribute("name")%></h1>

    <div class="button-wrapper" style="flex-direction: column;align-items: center">
<button style="width: 200px"  class="button" onclick="location.href='/room?light=TRUE'">Turn ON the light</button>
<button style="width: 200px"  class="button" onclick="location.href='/room?light=FALSE'">Turn OFF the light</button>
        <button class="button" style="width: 200px"  onclick="location.href='/list'">Back to list of rooms</button>
    </div>

</div>
</body>
</html>
