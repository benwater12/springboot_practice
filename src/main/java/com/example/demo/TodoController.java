package com.example.demo;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;//取得Service物件

    @GetMapping("/todos")
    public String getTodoList (Model model) {
        //get all todos
        Iterable<Todo> todoList = todoService.getTodos();
        model.addAttribute("todolist", todoList);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "todolist.html";
    }
    @PostMapping("/todos")
    public String maketodotask (@ModelAttribute Todo todo,Model model) {
        //新增post後的服務
        Iterable<Todo> allTodoList = todoService.createTodo(todo);
        Todo emptyTodo = new Todo();
        //重新渲染todolist
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "todolist.html";
    }
    @GetMapping("/")
    public String getTodoLisC () {

        return "This the home page";
    }
}

