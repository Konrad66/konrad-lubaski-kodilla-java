package com.kodilla.spring.portfolio;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void printToDoList() {
        System.out.println(toDoList.getTasks());
    }
    public void printInProgressList() {
        System.out.println(inProgressList.getTasks());
    }
    public void printDoneList() {
        System.out.println(doneList.getTasks());
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
