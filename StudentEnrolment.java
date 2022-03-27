import java.util.ArrayList;

public class StudentEnrolment implements StudentEnrolmentManager{
    Course course = new Course();
    Student student = new Student(123, "123", "abc");

    public static void enrol(){
        StudentEnrolmentManager.add();
    }
}
