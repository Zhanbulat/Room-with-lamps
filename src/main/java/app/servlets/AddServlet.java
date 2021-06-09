package app.servlets;

import app.entities.Room;
import app.entities.Utility;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Room room = new Room(name, country);
        room.setLight(false);
        Connection conn;
        try {
            conn = Utility.connectToDB();
            String sql = "INSERT INTO ROOMS(name,country,light) " + "VALUES(" + "'" + room.getName() + "'" + ",'" + room.getCountry() + "'," + room.getLight() + ");";
            conn.createStatement().executeUpdate(sql);
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("roomName", name);
        doGet(req, resp);
    }
}
