package com.manhlee.Servlet;

import com.manhlee.Model.Todo;
import com.manhlee.Model.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/todoAdd"})
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todoName= request.getParameter("todo");


        List<Todo> todos = null;
        HttpSession session = request.getSession();
        if(session.getAttribute("todos")!=null){
            todos = (List<Todo>) session.getAttribute("todos");
        }else{
            todos = new ArrayList<>();
        }
        int id= TodoService.generalTodoId(todos);
        Todo todo= new Todo(id,todoName,0);
        todos.add(todo);
        session.setAttribute("todos", todos);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
