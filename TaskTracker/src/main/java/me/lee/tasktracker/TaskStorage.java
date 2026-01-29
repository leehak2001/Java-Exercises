package me.lee.tasktracker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskStorage {
    private Path path;

    public TaskStorage(String location){
        this.path = Paths.get(location);

        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void test(){
        Task task1 = new Task(50, "hello");
        String str = toJsonLine(task1);
        System.out.println(str);
    }

//    public List<Task> loadTasks();
//
    public void saveTasks(List<Task> tasks) throws IOException {
         StringBuilder json = new StringBuilder("[\n");
         for (Task t: tasks){
             json.append(toJsonLine(t));
             json.append(", \n");
         }
         json.setLength(json.length()-3);
         json.append("\n]");

        Files.writeString(this.path, json.toString(), StandardCharsets.UTF_8);
    }

    //assisting functions
    public String toJsonLine(Task task){
        String id = String.valueOf(task.getId());
        String status = task.getStatus().name();
        return "{\n" +
                "\"id\": "+ id + ", \n" +
                "\"description\": " + "\""+ task.getDescription() + "\""+ ", \n" +
                "\"status\": " + "\""+ status + "\""+  ", \n" +
                "\"createdAt\": " +  "\""+ task.getCreatedAt() + "\""+ ", \n" +
                "\"updatedAt\":" + "\""+  task.getUpdatedAt() + "\""+ " }";
    }
    public static Task fromJsonBlock(String task){
        String[] lines = task.split("\n");
        for (String line: lines){

        }
    }

}
