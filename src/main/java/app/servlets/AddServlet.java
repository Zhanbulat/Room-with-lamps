package app.servlets;

import app.entities.Room;
import app.entities.Utility;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
            if(name.equals("") || country == null){
                req.setAttribute("empty","empty");
            }
            else {
                try {
                    req.setAttribute("exist","notexist");
                    Connection conn = Utility.connectToDB();
                    String sql="CREATE TABLE IF NOT EXISTS ROOMS (name varchar(50),country varchar(50),light varchar(50))";
                    conn.createStatement().execute(sql);
                    sql = "SELECT country FROM Rooms WHERE name=" +"'"+name+"'";
                    ResultSet rs = conn.createStatement().executeQuery(sql);
                    while (rs.next()) {
                        String countryCheck = rs.getString(("country"));
                        if (country.equals(countryCheck)) {
                            req.setAttribute("exist", "exist");
                            conn.close();
                            break;
                        }
                    }
                    if(req.getAttribute("exist").equals("notexist")) {
                        Room room = new Room(name, country);
                        room.setLight(false);
                        sql = "INSERT INTO ROOMS(name,country,light) " + "VALUES(" + "'" + room.getName() + "'" + ",'" + room.getCountry() + "'," + room.getLight() + ");";
                        conn.createStatement().executeUpdate(sql);
                        conn.close();
                        req.setAttribute("roomName", name);
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        doGet(req, resp);
}
}
