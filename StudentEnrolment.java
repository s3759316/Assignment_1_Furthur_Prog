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
    public String toString() {
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
    public void updateEnrolment(StudentEnrolment updateData, StudentEnrolment update) {
        updateData.setStudent(update.getStudent());
        updateData.setCourse(update.getCourse());
        updateData.setSemester(update.getSemester());
        System.out.println("Updated 1 enrollment:\n");
    }

    @Override
    public void deleteEnrolment() {
        Course course = new Course();
        Student student = new Student();
        Scanner scanner1 = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("Delete Enrolment: \n" +
                    "Please enter student ID: ");
            String studentID = scanner1.next();
            String valid = "";
            for (int i = 0; i < student.studentArray.size(); i++) {
                if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                    System.out.println("Valid ID");
                    valid = "valid";
                    break;
                }
                if (!studentID.equalsIgnoreCase(student.studentArray.get(student.studentArray.size() - 1).getID())) {
                    System.out.println("Not Valid ID");
                    break;
                }
            }
            if (!valid.equalsIgnoreCase("valid")){
                continue;
            }
            String enrolStudent = studentID;
            while (loop){
                System.out.println("Please enter course ID: ");
                studentID = scanner1.next();
                valid = "";
                for (int i = 0; i < course.courseArray.size(); i++) {
                    if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                        System.out.println("Valid Course ID");
                        valid = "valid";
                        break;
                    }
                    if (!studentID.equalsIgnoreCase(course.courseArray.get(course.courseArray.size() - 1).getCourseID())) {
                        System.out.println("Not Valid Course ID");
                        break;
                    }
                }
                if (!valid.equalsIgnoreCase("valid")){
                    continue;
                }
                String enrolCourse = studentID;
                while (loop){
                    System.out.println("Please enter semester: (2020B - 2021A)");
                    studentID = scanner1.next();
                    valid = "";
                    ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
                    for (int i = 0; i < semester.size(); i++) {
                        if(!studentID.equalsIgnoreCase(semester.get(i))){
                            System.out.println("Valid Semester");
                            valid = "valid";
                            break;
                        }
                        if (!studentID.equalsIgnoreCase(semester.get(semester.size()-1))) {
                            System.out.println("Not Valid Course ID");
                            break;
                        }
                    }
                    if (!valid.equalsIgnoreCase("valid")){
                        continue;
                    }
                    String delete = "";
                    for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                        if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                            studentEnrolment.remove(i);
                            delete = "delete";
                            System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                            break;
                        }
                    }
                    if (delete.equalsIgnoreCase("delete")){
                        loop = false;
                    }
                    else{
                        System.out.println("Cannot find enrolment");
                        break;
                    }
                }
                break;
            }
            break;
        }
    }

    @Override
    public void getOne() {
        Course course = new Course();
        Student student = new Student();
        Scanner scanner1 = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("Delete Enrolment: \n" +
                    "Please enter student ID: ");
            String studentID = scanner1.next();
            String valid = "";
            for (int i = 0; i < student.studentArray.size(); i++) {
                if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                    System.out.println("Valid ID");
                    valid = "valid";
                    break;
                }
                if (!studentID.equalsIgnoreCase(student.studentArray.get(student.studentArray.size() - 1).getID())) {
                    System.out.println("Not Valid ID");
                    break;
                }
            }
            if (!valid.equalsIgnoreCase("valid")){
                continue;
            }
            String enrolStudent = studentID;
            while (loop){
                System.out.println("Please enter course ID: ");
                studentID = scanner1.next();
                valid = "";
                for (int i = 0; i < course.courseArray.size(); i++) {
                    if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                        System.out.println("Valid Course ID");
                        valid = "valid";
                        break;
                    }
                    if (!studentID.equalsIgnoreCase(course.courseArray.get(course.courseArray.size() - 1).getCourseID())) {
                        System.out.println("Not Valid Course ID");
                        break;
                    }
                }
                if (!valid.equalsIgnoreCase("valid")){
                    continue;
                }
                String enrolCourse = studentID;
                while (loop){
                    System.out.println("Please enter semester: (2020B - 2021A)");
                    studentID = scanner1.next();
                    valid = "";
                    ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
                    for (int i = 0; i < semester.size(); i++) {
                        if(!studentID.equalsIgnoreCase(semester.get(i))){
                            System.out.println("Valid Semester");
                            valid = "valid";
                            break;
                        }
                        if (!studentID.equalsIgnoreCase(semester.get(semester.size()-1))) {
                            System.out.println("Not Valid Course ID");
                            break;
                        }
                    }
                    if (!valid.equalsIgnoreCase("valid")){
                        continue;
                    }
                    String exist = "";
                    for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                        if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                            System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).toString());
                            exist = "exist";
                            break;
                        }
                    }
                    if (exist.equalsIgnoreCase("exist")){
                        loop = false;
                    }
                    else{
                        System.out.println("Cannot find enrolment");
                        break;
                    }
                }
                break;
            }
            break;
        }
    }

    @Override
    public void getAll() {
        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
            System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).toString());
        }
    }

//    @Override
//    public ArrayList<StudentEnrolment> getAllEnrolments() {
//        return this.enrolmentList;
//    }
}

