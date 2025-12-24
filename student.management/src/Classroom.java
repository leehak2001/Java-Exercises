
public interface Classroom {

    void addStudent(Student student);
    void removeStudent(int studentId);
    void updateGrade(int studentId, int grade);
    void printAll();

}
