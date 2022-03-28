public class CreateStudent {

    Student student = new Student();

    public CreateStudent addId(String id){
        student.setID(id);
        return this;
    }

    public CreateStudent addName(String name){
        student.setName(name);
        return this;
    }

    public CreateStudent addBirthdate(String dob){
        student.setBirthdate(dob);
        return this;
    }

    public Student createStudent(){
        return student;
    }
}
