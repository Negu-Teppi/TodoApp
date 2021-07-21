<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.manhlee.Model.Todo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo App</title>
</head>
<body>
<h1>Todo!</h1><br>
<form action="todoAdd" method="post">
    <input type="text" name="todo">
    <input type="submit" value="Add">
</form>
<%
    List<Todo> todos = new ArrayList<>();
    if (session.getAttribute("todos") != null) {
        todos = (List<Todo>) session.getAttribute("todos");
    }
%>


<%--<ul><%if(todos!=null){
    for(Todo todo: todos){%>
    <li><%
            if(todo.getStatus()==0){
        %>
            <label style="color: red"><%=todo.getName()%></label>
            <a href="del?id=<%=todo.getId()%>">Del</a>
            <a href="edit?id=<%=todo.getId()%>">Done</a>
        <%
            }else{
        %>
            <label style="color: blue"><%=todo.getName()%></label>
            <a href="del?id=<%=todo.getId()%>">Del</a>
            <a href="edit?id=<%=todo.getId()%>">Re-Open</a>
        <%
            }
        %>
    </li>

    <%}}%>
</ul>--%>

    <ul>
        <c:if test="${todos!=null}">
            <c:forEach var="todo" items="${todos}">
                <li>
                    <%--<label style="color: red">${todo.name}</label>
                    <a href="del?id=${todo.id}">Del</a>
                    <a href="edit?id=${todo.id}">Done</a>--%>
                    <c:choose>
                        <c:when test="${todo.status==0}">
                            <label style="color: red">${todo.name}</label>
                            <a href="del?id=${todo.id}">Del</a>
                            <a href="edit?id=${todo.id}">Done</a>
                        </c:when>
                        <c:otherwise>
                        <label style="color: green">${todo.name}</label>
                        <a href="del?id=${todo.id}">Del</a>
                        <a href="edit?id=${todo.id}">Re-open</a>
                        </c:otherwise>
                    </c:choose>
                </li>

            </c:forEach>
        </c:if>
    </ul>
</body>
</html>