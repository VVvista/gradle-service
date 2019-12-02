package com.gsgradle.example.todoitem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Wen TingTing by 2019/11/26
 */
public class InMemoryToDoRepository implements com.gsgradle.example.todoitem.ToDoRepository {
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, com.gsgradle.example.todoitem.ToDoItem> toDos = new ConcurrentHashMap<Long, com.gsgradle.example.todoitem.ToDoItem>();


    @Override
    public List<com.gsgradle.example.todoitem.ToDoItem> findAll() {
        List<com.gsgradle.example.todoitem.ToDoItem> toDoItems = new ArrayList<com.gsgradle.example.todoitem.ToDoItem>(toDos.values());
        return toDoItems;
    }

    @Override
    public com.gsgradle.example.todoitem.ToDoItem findById(Long id) {
        return toDos.get(id);
    }

    @Override
    public Long insert(com.gsgradle.example.todoitem.ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        toDos.putIfAbsent(id, toDoItem);
        return id;
    }

    @Override
    public void update(com.gsgradle.example.todoitem.ToDoItem toDoItem) {
        toDos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(com.gsgradle.example.todoitem.ToDoItem toDoItem) {
        toDos.remove(toDoItem.getId());
    }
}
