import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("---student management system---");
        ArrayList<Student> students = new ArrayList<>();
        Teacher t1 = new Teacher("Bob", 123);
        Student s1 = new Student("Jim", 12345678, 90);
        Student s2 = new Student("May", 18236494, 67);
        Student s3 = new Student("Ron", 18298494, 97);
        Student s4 = new Student("Jon", 18298494, 97);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        SchoolClass class1 = new SchoolClass(students, 1, t1);
        class1.printall();
        class1.removeStudent(s1);
        class1.printall();
        class1.addStudent(s1);
        class1.printall();
        class1.updateGrade(s1, 100);
        class1.addStudent(s4);
        class1.printall();

    }
}