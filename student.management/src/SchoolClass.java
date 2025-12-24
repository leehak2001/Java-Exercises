import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SchoolClass implements Classroom{

    HashMap<Integer, Student> students;
    int grade;
    Teacher teacher;

    public SchoolClass(Collection<Student> students, int grade, Teacher teacher){
        this.setStudents(students);
        this.grade = grade;
        this.teacher = teacher;
    }


    public void setStudents(Collection<Student> students ){
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
    public void printAll() {

        for(Student s : this.getStudents().values()){
            System.out.println(s);
        }
    }

    @Override
    public void addStudent(Student student){
        if(idNotDuplicates(student)){
            this.getStudents().put(student.getId(), student);
        }
    }
    @Override
    public void removeStudent(int studentId){
        this.getStudents().remove(studentId);
    }
     @Override
    public void updateGrade(int studentId, int grade){
        if( this.students.containsKey(studentId)){
            this.getStudents().get(studentId).setGrade(grade);
        }
        else{
            System.out.println("Student not found");
        }
     }
}
