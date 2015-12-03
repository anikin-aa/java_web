package Servlet;

import DAO.Dao;
import Data.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().isEmpty()) {
            request.getRequestDispatcher("table.jsp").forward(request, response);
        }
        String action = request.getParameter("action");
        System.out.println(action);
        if (action != null) {
            switch (action) {
                case "view":
                    Integer id = Integer.valueOf(request.getParameter("id"));
                    System.out.println(id);
                    request.setAttribute("user", new Dao().getUserById(id));
                    request.getRequestDispatcher("view.jsp").forward(request, response);
                    System.out.println(1);
                    break;
                case "save":
                    break;
                case "delete":
                    break;
            }
        }
    }
}
