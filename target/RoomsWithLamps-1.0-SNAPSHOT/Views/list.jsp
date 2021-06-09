<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.ServletContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
</head>

<body>
<div>
    <h1>Комнаты с лампочками</h1>
</div>

<div>
    <div>
        <div>
            <h2>Список комнат</h2>


        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("roomNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li><a href='/room?name="+s+"'>"+s+"</a></li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no rooms yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
<div>
    <%if(request.getAttribute("error")!=null&&request.getAttribute("error").equals("error")){
        out.println("У вас нет доступа в эту комнату");
    }
    %>
</div>
</body>
</html>