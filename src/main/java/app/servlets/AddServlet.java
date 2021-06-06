package app.servlets;

import app.entities.Room;
import app.model.Model;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("country");
        Room room = new Room(name, password);
        room.setLight(false);
        Model model = Model.getInstance();
        model.add(room);
        req.setAttribute("roomName", name);
        doGet(req, resp);
    }
}
