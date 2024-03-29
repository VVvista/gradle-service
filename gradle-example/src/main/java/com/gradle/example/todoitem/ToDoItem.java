package com.gradle.example.todoitem;

/**
 * @author Wen TingTing by 2019/11/26
 */
public class ToDoItem {
    private Long id;
    private String name;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
