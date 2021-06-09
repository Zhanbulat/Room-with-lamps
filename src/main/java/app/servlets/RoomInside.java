package app.servlets;

import app.entities.Utility;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;


public class RoomInside extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String roomName = req.getParameter("name");
        HttpSession session = req.getSession();
        if (roomName != null) {
            session.setAttribute("name", roomName);
        }
        try {
            String light = req.getParameter("light");
            conn = Utility.connectToDB();
            String sql = "SELECT country FROM Rooms " +
                    "WHERE name=" + "'" + session.getAttribute("name") + "';";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            rs.next();
            String country = rs.getString("country");
            req.setAttribute("country", country);
            if (!req.getRemoteAddr().equals("0:0:0:0:0:0:0:1") && !Utility.getCountryByIp(req.getRemoteAddr()).equals(req.getAttribute("country"))) {
                req.setAttribute("error", "error");
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/list");
                requestDispatcher.forward(req, resp);
            } else {
                if (light != null) {
                    sql = "UPDATE Rooms " + "SET light =" + light + " WHERE name=" + "'" + session.getAttribute("name") + "'";
                    conn.createStatement().executeUpdate(sql);
                    ServletContext servletContext = getServletContext();
                    servletContext.setAttribute(session.getAttribute("name") + "light", light);
                } else {
                    ServletContext servletContext = getServletContext();
                    sql = "SELECT light FROM Rooms " +
                            "WHERE name=" + "'" + session.getAttribute("name") + "';";
                    rs = conn.createStatement().executeQuery(sql);
                    rs.next();
                    light = rs.getString("light");

                    servletContext.setAttribute(session.getAttribute("name") + "light", light);
                    conn.close();
                }
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/room.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}