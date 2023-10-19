package com.Geekster.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    List<Todo> todoList;


    @PostMapping("todo")
    public String addTodo(@RequestBody Todo myTodo){

        todoList.add(myTodo);

        return "To do Added";
    }

    @GetMapping("todos")
    public List<Todo> getAllTodos(){

        return todoList;
    }


    @PutMapping("todo/id/{Id}/status")
    public String setTodoStatusById(@PathVariable Integer Id, @RequestParam boolean flag){

        for(Todo todo : todoList){

            if(todo.getTodoId().equals(Id)){
                todo.setTodoStatus(flag);
                return "todo:"    +  Id + "updated to" +   flag;
            }


        }

        return "Invalid Id";
    }

    @DeleteMapping("todo/id/{id}")
    public String deleteTodoStatusById(@PathVariable Integer id){

        for(Todo todo : todoList){

            if(todo.getTodoId().equals(id)){
                todoList.remove(todo);
                return "todo:"    +  id  +   "Removed";
            }


        }
        return "Invalid Id";
    }

    @PostMapping("todos")
    public String addAllTodos(@RequestBody List<Todo> myTodos){

        todoList.addAll(myTodos);

        return myTodos.size() + "Todos were Added";
    }

}
