package me.lee.tasktracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFile {

    private Path path;

    JsonFile(String url){
        this.setPath(url);

        if(!Files.exists(this.path)){
            try {
                Files.writeString(this.path, "[]");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setPath(String url) {
        path = Paths.get(url);
    }

    public Path getPath(){
        return this.path;
    }

    public void add(String description){
        System.out.println("Task added successfully ID: ");
    }

    public void delete(int id){
        System.out.println("Task ID: "+ id + " deleted");
    }

    public void update(int id, String description){
        System.out.println("Task ID: "+ id + " updated");
    }
    public void mark(String status, int id){
        System.out.println("Task ID: "+ id + " updated");
    }

    public void list(String type){
        System.out.println("list type: "+type);
    }
    public void list(){
        System.out.println("list type: ");
    }

}
