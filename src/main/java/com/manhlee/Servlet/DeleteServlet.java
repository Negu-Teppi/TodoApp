package com.manhlee.Servlet;

import com.manhlee.Model.Todo;
import com.manhlee.Model.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "DeleteServlet", value = "/del")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        List<Todo> todos = (List<Todo>) session.getAttribute("todos");
        TodoService.deleteTodoById(todos,id);
        session.setAttribute("todos", todos);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
