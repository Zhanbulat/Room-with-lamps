package app.servlets;


import app.entities.Room;
import app.model.Model;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

public class RoomInside extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomName=req.getParameter("name");
        String light=req.getParameter("light");
        HttpSession session = req.getSession();
        ServletContext servletContext=getServletContext();
        if(roomName != null) {
            session.setAttribute("name", roomName);
        }
        if(light != null) {
            servletContext.setAttribute(session.getAttribute("name")+"light", light);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/room.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}