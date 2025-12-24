public class Student extends Person{
    private int grade;

    public Student(String name, int id, int grade){
        super(name, id);
        this.setGrade(grade);
    }

    public void setGrade(int grade){
        if(grade<0 || grade>100){
            System.out.println("invalid grade");
            this.grade= 0;
        }else
        {
            this.grade = grade;
        }
    }

    public int getGrade(){
        return this.grade;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + " id: " + this.getId() + " grade: " + this.grade;
    }
}
