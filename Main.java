import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Student student = new Student();
        Course course = new Course();
        Scanner scanner1 = new Scanner(System.in);
        StudentEnrolment studentEnrolment = new StudentEnrolment();
        ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
        boolean loop = true;

        try {
            File sourceData = new File("default.csv");
            Scanner fileReader = new Scanner(sourceData);
            int count = 0;
            while (fileReader.hasNextLine()) {
                String info = fileReader.nextLine();
                System.out.println(info);
                String duplicate = "no";
                String duplicate1 = "no";

                if (student.studentArray.size() == 0){
                    Student student1 = new Student(info.split(",")[0],info.split(",")[1] ,info.split(",")[2]);
                    student.studentArray.add(student1);
                }
                else {
                    for (int i = 0; i < student.studentArray.size(); i++) {
                        if (student.studentArray.get(i).getID().equalsIgnoreCase(info.split(",")[0])) {
                            duplicate = "yes";
                            break;
                        }
                    }
                    if (duplicate.equalsIgnoreCase("no")) {
                        Student student2 = new Student(info.split(",")[0], info.split(",")[1], info.split(",")[2]);
                        student.studentArray.add(student2);
                    }
                }

                if (course.courseArray.size() == 0){
                    Course course1 = new Course(info.split(",")[3],info.split(",")[4] ,info.split(",")[5]);
                    course.courseArray.add(course1);
                }
                else {
                    for (int i = 0; i < course.courseArray.size(); i++) {
                        if (course.courseArray.get(i).getCourseID().equalsIgnoreCase(info.split(",")[3])) {
                            duplicate1 = "yes";
                            break;
                        }
                    }
                    if (duplicate1.equalsIgnoreCase("no")) {
                        Course course2 = new Course(info.split(",")[3], info.split(",")[4], info.split(",")[5]);
                        course.courseArray.add(course2);
                    }
                }

                StudentEnrolment  enrolment = new StudentEnrolment(info.split(",")[0], info.split(",")[3], info.split(",")[6]);
                StudentEnrolmentManager.studentEnrolment.add(enrolment);
            }
            fileReader.close();
            System.out.println("Data Received");
            System.out.println("\n");
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("ERROR, FILE NOT FOUND");
        }

        Scanner scanner = new Scanner(System.in);
        String condition = null;
        while (!Objects.equals(condition, "quit")){
            System.out.println("\nWelcome to student enrolment system!\n" +
                               "What would you like to do?\n" +
                               "1) Add Enrolment\n" +
                               "2) Update existing enrolment\n" +
                               "3) Delete existing enrolment\n" +
                               "4) Print all courses of one student in one semester\n" +
                               "5) Print all students of one course in one semester\n" +
                               "6) Print all courses in one semester\n" +
                               "7) Print all enrolment\n" +
                               "8) Print one enrolment\n" +
                               "9) Quit");
            String option = "";
            if(scanner.hasNext()){
                option = scanner.next();
            }

            switch (option){
                case "1":
                    for (int i = 0; i < student.studentArray.size(); i++) {
                        System.out.println(student.studentArray.get(i).getID());
                    }
                    loop = true;
                    while(loop){
                        System.out.println("Creating new enrolment: \n" +
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
                                String fin = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                        enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                        studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())){
                                        exist = "exist";
                                    }
                                    if (exist.equalsIgnoreCase("exist")){
                                        System.out.println("Enrolment Already Existed");
                                        System.out.println("Please Choose Another Semester");
                                        break;
                                    }
                                }
                                if (!exist.equalsIgnoreCase("exist")){
                                    StudentEnrolment studentEnrolment1 = new StudentEnrolment(enrolStudent,enrolCourse,studentID);
                                    studentEnrolment.addEnrolment(studentEnrolment1);
                                    fin = "fin";
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                }
                                if (!fin.equalsIgnoreCase("fin")){
                                    continue;
                                }
                                loop = false;
                            }
                        }
                    }
                    continue;
//                case "2":
//
//                    continue;

                case "3":
                    studentEnrolment.deleteEnrolment();
                    continue;

                case "4":
                    loop = true;
                    while(loop){
                        System.out.println("Print All Course Of One Student In One Semester: \n" +
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
                        System.out.println("Please enter semester: ");
                        String Semester = scanner1.next();
                        valid = "";
                        for (int i = 0; i < semester.size(); i++) {
                            if (Semester.equalsIgnoreCase(semester.get(i))) {
                                System.out.println("Valid Semester");
                                valid = "valid";
                                break;
                            }
                            if (!Semester.equalsIgnoreCase(semester.get(semester.size() - 1))) {
                                System.out.println("Not Valid Semester");
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")){
                            continue;
                        }
                        System.out.println("Course of " + studentID);
                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                            if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())){
                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                            }
                        }
                        loop = false;
                    }
                    continue;

                case "5":
                    loop = true;
                    while(loop){
                        System.out.println("Print All Student In One Course In One Semester: \n" +
                                           "Please enter course ID: ");
                        String courseID = scanner1.next();
                        String valid = "";
                        for (int i = 0; i < course.courseArray.size(); i++) {
                            if (courseID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                System.out.println("Valid Course ID");
                                valid = "valid";
                                break;
                            }
                            if (!courseID.equalsIgnoreCase(course.courseArray.get(course.courseArray.size() - 1).getCourseID())) {
                                System.out.println("Not Valid Course ID");
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")){
                            continue;
                        }
                        System.out.println("Please enter semester: ");
                        String Semester = scanner1.next();
                        valid = "";
                        for (int i = 0; i < semester.size(); i++) {
                            if (Semester.equalsIgnoreCase(semester.get(i))) {
                                System.out.println("Valid Semester");
                                valid = "valid";
                                break;
                            }
                            if (!Semester.equalsIgnoreCase(semester.get(semester.size() - 1))) {
                                System.out.println("Not Valid Semester");
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")){
                            continue;
                        }
                        System.out.println("Students in course: " + courseID);
                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                            if (courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())){
                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getStudent());
                            }
                        }
                        loop = false;
                    }
                    continue;

                case "6":
                    
                    continue;

                case "7":
                    studentEnrolment.getAll();
                    continue;

                case "8":
                    studentEnrolment.getOne();
                    continue;

                case "9":
                    condition = "quit";
            }
        }
    }
}
