package com.deved.usermanagement.controllers;

import com.deved.usermanagement.dao.UserDAO;
import com.deved.usermanagement.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/update/*")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = UserDAO.getUser(userId);

        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("updateuser.jsp");
        rd.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        boolean updated = UserDAO.updateUser(new User(userId, firstName, lastName, email));
        if(updated) {
            response.sendRedirect("list");
        }
    }
}
