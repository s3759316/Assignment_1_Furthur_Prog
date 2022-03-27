import java.util.ArrayList;
import java.util.Date;

public class Student {
    private int ID;
    private String name;
    private String birthdate;

    ArrayList<Object> studentArray = new ArrayList<Object>();

    public Student(){

    }
    @Override
    public String toString() {
        return "Student No: " + this.getID() +
                ", Student Name: " + this.getName() +
                ", Date of Birth: " + this.getBirthdate();
    }

    public Student(int ID, String name, String birthdate) {
        this.ID = ID;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
}
