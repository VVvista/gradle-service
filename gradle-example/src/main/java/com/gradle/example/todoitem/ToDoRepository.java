package com.gradle.example.todoitem;

import java.util.List;

/**
 * @author Wen TingTing by 2019/11/26
 */
public interface ToDoRepository {

    List<ToDoItem> findAll();

    ToDoItem findById(Long id);

    Long insert(ToDoItem toDoItem);

    void update(ToDoItem toDoItem);

    void delete(ToDoItem toDoItem);
}
