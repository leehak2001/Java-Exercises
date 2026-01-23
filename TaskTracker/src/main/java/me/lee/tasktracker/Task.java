package me.lee.tasktracker;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    int id;
    String description="";
    Status status= Status.TODO;
    String createdAt;
    String updatedAt="";
    private static int counter =0;

    //constractor
    public Task(String description){
        this.setId();
        this.setDescription(description);
        this.setCreatedAt();
    }

    //geters and setters
    private void setCreatedAt() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.createdAt = date.format(formatter);
    }

    private void setUpdatedAt() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.updatedAt = date.format(formatter);
    }

    private void setId() {
        this.id= counter;
        counter++;
    }

    public void setStatus(Status status) {
        this.status = status;
        setUpdatedAt();
    }

    public void setDescription(String description) {
        this.description = description;
        this.setUpdatedAt();
    }

    public int getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public Status getStatus(){
        return this.status;
    }

    public String getCreatedAt(){
        return this.createdAt;
    }

    public String getUpdatedAt(){
        return this.updatedAt;
    }


    //task opertions

    @Override
    public String toString(){

        return "id: " + this.id +
                "\ndescription: " +this.description+
                "\nstatus: " + this.status+
                "\ncreatedAt: " + this.createdAt+
                "\nupdatedAt: " + this.updatedAt;

    }
}



