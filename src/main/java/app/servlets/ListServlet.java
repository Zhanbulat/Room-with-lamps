package app.servlets;
import javax.servlet.*;

import app.model.Model;
import jakarta.servlet.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Model model = Model.getInstance();
        List<String> names = model.list();
        req.setAttribute("roomNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
