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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            Dao d = new Dao();
            User user = new Dao().getUserById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("user", user);
            request.getRequestDispatcher("view.jsp").forward(request, response);
            if (request.getParameter("submit").isEmpty()) {
                Integer id = Integer.valueOf(request.getParameter("id"));
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                Integer age = Integer.valueOf(request.getParameter("age"));
                Integer number = Integer.valueOf(request.getParameter("number"));
                Integer series = Integer.valueOf(request.getParameter("series"));
                d.updateUser(new User(id, name, email, surname, age, number, series));
            }
        }
    }
}
