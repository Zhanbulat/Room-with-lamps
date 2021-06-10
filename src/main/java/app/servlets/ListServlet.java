package app.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import app.entities.Utility;
import jakarta.servlet.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Connection conn = Utility.connectToDB();
            String sql="CREATE TABLE IF NOT EXISTS ROOMS (name varchar(50),country varchar(50), light varchar(50));";
            conn.createStatement().execute(sql);
            sql = "SELECT name,country FROM Rooms";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString("name")+"("+rs.getString("country")+")");
            }
            req.setAttribute("roomNames", names);
            conn.close();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/list.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
