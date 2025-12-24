public class Person {
    String name;
    int id;

    public Person(String name, int id){
        this.setName(name);
        this.setId(id);
    }

    public void setName(String name){
        this.name=name;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
}
