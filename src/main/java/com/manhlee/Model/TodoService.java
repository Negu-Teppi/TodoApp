package com.manhlee.Model;

import java.util.List;

public class TodoService {
    public static int generalTodoId(List<Todo> todos){
        int id=1;
        if(todos.size()>0){
            id= todos.get(todos.size()-1).getId()+1;
        }
        return id;
    }

    public static void deleteTodoById(List<Todo> todos, int id){
         Todo todoDelete = null;
         for (Todo todo:todos){
             if(todo.getId()==id){
                 todos.remove(todo);
                 return;
             }
         }
    }

    public static void changeStatusById(List<Todo> todos, int id){
        for (Todo todo:todos){
            if(todo.getId()==id){
                if(todo.getStatus()==0){
                    todo.setStatus(1);
                }else{
                    todo.setStatus(0);
                }
                return;
            }
        }
    }
}
