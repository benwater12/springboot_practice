package com.example.demo.service;
import com.example.demo.DAO.TodoDAO;
import com.example.demo.entity.Todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoDAO todoDao; // 取得Dao物件

    public Iterable<Todo> getTodos () {
        //對DAO物件下令取件
        return todoDao.findAll();
    }
    public Iterable<Todo> createTodo(Todo todo){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        todo.setCreateTime(date);
        todo.setUpdateTime(date);
        todoDao.save(todo);
        return getTodos();
    }
}