<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Rooms</h2>
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
</body>
</html>