//package me.lee.tasktracker;
//
//import jdk.dynalink.StandardOperation;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class JsonFile {
//
//    private Path path;
//    private static int id=1;
//
//    JsonFile(String url){
//        this.setPath(url);
//
//        if(!Files.exists(this.path)){
//            try {
//                Files.writeString(this.path, "{\"items\": []}");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }else{
//            //assaign the id to be the next id from the last in the file
//            try {
//                setId();
//            } catch (IOException e) {
//                System.out.println("couldn't assaign id");
//                throw new RuntimeException(e);
//            }
//
//        }
//    }
//
//    public void setId() throws IOException {
//        String content = Files.readString(this.path);
//        Pattern p = Pattern.compile("\"id\":\\s*(\\d+)");
//        Matcher m = p.matcher(content);
//
//        int maxId = 0;
//        while (m.find()) {
//            int foundId = Integer.parseInt(m.group(1));
//            if (foundId > maxId) {
//                maxId = foundId;
//            }
//        }
//        JsonFile.id = maxId + 1; // Start at the next available number
//    }
//
//    public void setPath(String url) {
//        path = Paths.get(url);
//    }
//
//    public Path getPath(){
//        return this.path;
//    }
//
//    public void add(String description) throws IOException {
//        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        LocalDateTime time = LocalDateTime.now();
//        String newTime= time.format(formmater);
//        String json = "{\n" +
//                "\"id\": "+ this.id + ", \n" +
//                "\"description\": " + "\""+ description + "\""+ ", \n" +
//                "\"status\": \"todo\"" + ", \n" +
//                "\"createdAt\": " +  "\""+ newTime + "\""+ ", \n" +
//                "\"updatedAt\": null}";
//
//        String correntJson = Files.readString(this.path);
//
//        // Using StringBuilder is better for large "append" operations
//        StringBuilder sb = new StringBuilder(correntJson);
//        // Delete the last 2 characters (e.g., the existing " ]}")
//        sb.setLength(sb.length() - 2);
//
//        if (correntJson.length() >= 3 && correntJson.charAt(correntJson.length() - 3) != '['){
//            sb.append(",");
//        }
//        sb.append("\n").append(json).append("]}");
//        Files.writeString(this.path, sb.toString(), StandardCharsets.UTF_8);
//        System.out.println("Task added successfully ID: " + id);
//        JsonFile.id++;
//    }
//
//    public void delete(String id) throws IOException {
//
//        String content = Files.readString(this.path);
//        String regex = "\\{\\s*\"id\":\\s*" + id + "[^}]*\\},";
//        Matcher m = Pattern.compile(regex).matcher(content);
//
//        if (m.find()) {
//            StringBuilder sb = new StringBuilder(content);
//            sb.delete(m.start(), m.end());
//            Files.writeString(this.path, sb.toString(), StandardCharsets.UTF_8);
//            System.out.println("Task id: "+id+" deleted");
//        }else{
//            System.out.println("no item with id: " +id + " was found");
//        }
//
//
//    }
//
//    //not done i need to update inside the item not the whole item
//    public void update(String id, String description) throws IOException {
//        String content = Files.readString(this.path);
//        String regex = "\\{\\s*\"id\":\\s*" + id + "[^}]*\\},";
//        Matcher m = Pattern.compile(regex).matcher(content);
//
//        if(m.find()){
//            StringBuilder sb = new StringBuilder(content);
//            sb.replace(m.start(), m.end(), description);
//
//            regex = "\"description\":\\s*\"[^\"]*";
//            m = Pattern.compile(regex).matcher(m);
//            Files.writeString(this.path, sb.toString(), StandardCharsets.UTF_8);
//            System.out.println("Task ID: "+ id + " updated");
//        }else{
//            System.out.println("Task ID: "+ id + " couldn't be updated");
//        }
//    }
//    public void mark(String status, int id){
//        System.out.println("Task ID: "+ id + " updated");
//    }
//
//    public void list(String type){
//        System.out.println("list type: "+type);
//
//    }
//    public void list(){
//        System.out.println("list type: ");
//    }
//
//}
