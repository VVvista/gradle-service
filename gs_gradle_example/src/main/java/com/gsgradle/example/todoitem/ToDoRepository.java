package com.gsgradle.example.todoitem;

import java.util.List;

/**
 * @author Wen TingTing by 2019/11/26
 */
public interface ToDoRepository {

    List<com.gsgradle.example.todoitem.ToDoItem> findAll();

    com.gsgradle.example.todoitem.ToDoItem findById(Long id);

    Long insert(com.gsgradle.example.todoitem.ToDoItem toDoItem);

    void update(com.gsgradle.example.todoitem.ToDoItem toDoItem);

    void delete(com.gsgradle.example.todoitem.ToDoItem toDoItem);
}
