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

@WebServlet(name = "InsertUser", value = "/insert")
public class InsertUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        User newUser = new User(firstName, lastName, email);

        boolean registerUser = UserDAO.registerUser(newUser);

        if (registerUser) {
            System.out.println("Added to DB");
            response.sendRedirect("list");
        }
    }
}
