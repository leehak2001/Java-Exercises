package me.lee.tasktracker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Task task1 = new Task("hello");
//        Task task2 = new Task("are you holding on?");
        TaskManager manager = new TaskManager();
        manager.addTask("hello");
        manager.addTask("i am form the manager");
        List<Task> tasks = manager.getAllTasks();

        for(Task t : tasks){
            System.out.println(t);
        }
}}