import java.util.ArrayList;
import java.util.Scanner;

public interface StudentEnrolmentManager {
    ArrayList<String> studentEnrolment = new ArrayList<String>();
    Course course = new Course();
    Student student = new Student(123, "123", "abc");

    static void add(){
        String name;
        String courseName;
        String semester;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student ID: ");
        int studentID = scanner.nextInt();


        ArrayList<String> addEnrolment = new ArrayList<String>();
        name = student.getName();
        courseName = course.getName();

    }

    static void delete(){

    }

    static void update(){

    }

    static void getOne(){

    }

    static void getAll(){

    }
}
