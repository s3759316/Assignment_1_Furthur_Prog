import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String ID;
    private String name;
    private String birthdate;

    ArrayList<Student> studentArray = new ArrayList<Student>();

    public Student(){

    }

    public Student(String ID, String name, String birthdate) {
        this.ID = ID;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String  getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString(){
        return "id: " + ID + " " +
                "| name: " + name + " " +
                "| noCredits: " + birthdate;
    }

    public void getAllStudents() {
        for (Student student : studentArray) {
            System.out.println(student.toString());
        }
    }
}
