package me.lee.tasktracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    private HashMap<Integer, Task> tasks;
    private int counter =0;

    //constractor
    public TaskManager(){
        this.tasks = new HashMap<>();
    }
    public TaskManager(List<Task> tasks){
        this.tasks = new HashMap<>();
        //convert the list into a hash map
        for(Task t : tasks){
            this.tasks.put(t.getId(), t);
        }
    }

    //actions on all lists
    public void addTask(String description){
        Task temp = new Task(counter, description);
        counter++;
        this.tasks.put(temp.getId(), temp);
    }

    public List<Task> getAllTasks(){
        return new ArrayList<Task>(this.tasks.values());
    }

    public Task getTaskById(int id){
        return this.tasks.get(id);
    }

    public boolean updateTask(int id, String newDescription){
        Task task = this.tasks.get(id);
        if(task==null){
           return false;
        }
        task.setDescription(newDescription);
        return true;
    }
    public boolean deleteTask(int id){
        if(this.tasks.containsKey(id)){
            this.tasks.remove(id);
            return true;
        }
        return false;
    }
    public boolean markTask(int id, Status status){
        Task task = this.tasks.get(id);
        if(task==null){
            return false;
        }
        task.setStatus(status);
        return true;
    }
}
