package me.lee.tasktracker;

public class Main {
    public static void main(String[] args) {
//        JsonFile file = new JsonFile("C:\\Users\\PC\\Desktop\\projects\\7_month_plan\\Java-Exercises\\TaskTracker\\src\\main\\java\\me\\lee\\test.json");
//        try {
//            String action = args[0];
//            switch (action) {
//                case "add":
//                    file.add(args[1]);
//                    break;
//                case "delete":
//                    file.delete(args[1]);
//                    break;
//                case "update":
//                    file.update(args[1], args[2]);
//                    break;
//                case "list":
//                    if(args.length>1){
//                        file.list(args[1]);
//                    }else{
//                        file.list();
//                    }
//                    break;
//                default:
//                    System.out.println("invalid action detected please try something else");
//                    break;
//            }
//        } catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println("there are missing arguments, please try again");
//        }catch (Exception e) {
//            System.out.println("error: " + e);
//        }

        Task task1 = new Task("hello");
        Task task2 = new Task("are you holding on?");
        System.out.println(task1);
        System.out.println(task2);
}}