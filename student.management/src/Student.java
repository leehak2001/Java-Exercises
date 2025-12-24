public class Student extends Person{
    int grade;

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

    public void print(){
        System.out.println("name: " + this.getName() + " id: " + this.getId() + " grade: " + this.getGrade());
    }
}
