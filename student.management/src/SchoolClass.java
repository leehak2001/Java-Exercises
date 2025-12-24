import java.util.ArrayList;
import java.util.HashMap;

public class SchoolClass implements Classroom{

    HashMap<Integer, Student> students;
    int grade;
    Teacher teacher;

    public SchoolClass(ArrayList<Student> students, int grade, Teacher teacher){
        this.setStudents(students);
        this.grade = grade;
        this.teacher = teacher;
    }


    public void setStudents(ArrayList<Student> students){
        this.students = new HashMap<>();

         for (Student s : students){
             if(idNotDuplicates(s))
                this.students.put(s.getId(), s);
        }
    }

    public HashMap<Integer, Student> getStudents(){
        return this.students;
    }

    private boolean idNotDuplicates(Student s){
        if( this.students.containsKey(s.getId())){
            System.out.println("couldn't add student: " + s.getName() + "found duplicate id: " + s.getId() );
            return false;
        }
        return true;
    }

    @Override
    public void printall() {

        for(Student s : this.getStudents().values()){
            s.print();
        }
    }

    @Override
    public void addStudent(Student student){
        if(idNotDuplicates(student)){
            this.getStudents().put(student.getId(), student);
        }
    }
    @Override
    public void removeStudent(Student student){
        this.getStudents().remove(student.getId());
    }
     @Override
    public void updateGrade(Student student, int grade){
        this.getStudents().get(student.getId()).setGrade(grade);
     }
}
