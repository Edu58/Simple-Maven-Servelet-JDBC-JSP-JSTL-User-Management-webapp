package com.deved.usermanagement.controllers;

import com.deved.usermanagement.dao.UserDAO;
import com.deved.usermanagement.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UsersListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> getUsers = UserDAO.usersList();
        request.setAttribute("users", getUsers);
        RequestDispatcher rd = request.getRequestDispatcher("userslist.jsp");
        rd.forward(request, response);
    }
}
