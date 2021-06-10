<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.ServletContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
    <link href="Views/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div>
    <h1>Rooms with light bulbs</h1>
</div>

<div>
    <div>
        <div>
            <h2>List of rooms:</h2>


        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("roomNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li class='list-item'><a style='text-decoration:none' href='/room?name="+s+"'>"+s+"</a></li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no rooms yet!</p>");
        %>
    </div>
</div>

<div>
    <button class="button" onclick="location.href='/'">Back to main</button>
</div>
<div>
    <%if(request.getAttribute("error")!=null&&request.getAttribute("error").equals("error")){
        out.println("You do not have access to this room");
    }
    %>
</div>
</body>
</html>