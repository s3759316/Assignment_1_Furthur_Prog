import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager{

    private String student;
    private String course;
    private String semester;

    public StudentEnrolment(){}

    public StudentEnrolment(String student, String course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {      // Convert enrolment information to string in order to print
        return "student: " + student +
                " | course: " + course +
                " | Semester: " + semester;
    }

    @Override
    public void addEnrolment(StudentEnrolment newEnrolment) {
        studentEnrolment.add(newEnrolment);
        System.out.println("Enrolment Create Successfully! " + newEnrolment.toString());
    }

    @Override
    public void updateEnrolmentdelete(StudentEnrolment updateDelete) {
        studentEnrolment.remove(updateDelete);
    }

    @Override
    public void updateEnrolmentadd(StudentEnrolment updateAdd) {
        studentEnrolment.add(updateAdd);
    }

    @Override
    public void deleteEnrolment(StudentEnrolment delete) {
        studentEnrolment.remove(delete);
    }

    @Override
    public void getOne(int One) {
        System.out.println(studentEnrolment.get(One).toString());
    }

    @Override
    public void getAll() {
        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
            System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).toString());
        }
    }
}

