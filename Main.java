import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        Course course = new Course();
        Scanner scanner1 = new Scanner(System.in);
        StudentEnrolment studentEnrolment = new StudentEnrolment();
        ArrayList<String> semester = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
        boolean loop;

        try {
            File sourceData = new File("default.csv");
            Scanner fileReader = new Scanner(sourceData);
            System.out.println("Default info: ");
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
            System.out.println("""

                    Welcome to student enrolment system!
                    What would you like to do?
                    1) Add Enrolment
                    2) Update existing enrolment
                    3) Delete existing enrolment
                    4) Print all courses of one student in one semester
                    5) Print all students of one course in one semester
                    6) Print all courses in one semester
                    7) Print all enrolment
                    8) Print one enrolment
                    9) Print all info (student, course or enrolment)
                    10) Quit""");
            String option = "";
            if(scanner.hasNext()){
                option = scanner.next();
            }

            switch (option) {
                case "1" -> {
                    loop = true;
                    while (loop) {
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
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid ID");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop) {
                            System.out.println("Please enter course ID: ");
                            studentID = scanner1.next();
                            valid = "";
                            for (int i = 0; i < course.courseArray.size(); i++) {
                                if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                    System.out.println("Valid Course ID");
                                    valid = "valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("valid")) {
                                System.out.println("Not Valid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop) {
                                System.out.println("Please enter semester: (2020B - 2021A)");
                                studentID = scanner1.next();
                                valid = "";
                                for (String s : semester) {
                                    if (!studentID.equalsIgnoreCase(s)) {
                                        System.out.println("Valid Semester");
                                        valid = "valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("valid")) {
                                    System.out.println("Not Valid Semester");
                                    continue;
                                }
                                String exist = "";
                                String fin = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                        exist = "exist";
                                    }
                                    if (exist.equalsIgnoreCase("exist")) {
                                        System.out.println("Enrolment Already Existed");
                                        System.out.println("Please Choose Another Semester");
                                        break;
                                    }
                                }
                                if (!exist.equalsIgnoreCase("exist")) {
                                    StudentEnrolment studentEnrolment1 = new StudentEnrolment(enrolStudent, enrolCourse, studentID);
                                    studentEnrolment.addEnrolment(studentEnrolment1);
                                    fin = "fin";
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                }
                                if (!fin.equalsIgnoreCase("fin")) {
                                    continue;
                                }
                                loop = false;
                            }
                        }
                    }
                }
                case "2" ->{
                    loop = true;
                    System.out.println("Updating enrolment of student: ");
                    while (loop) {
                        System.out.println("Please enter your student id:");
                        String studentId = scanner.next();
                        String valid = "";
                        for (int i = 0; i < student.studentArray.size(); i++) {
                            if (studentId.equalsIgnoreCase(student.studentArray.get(i).getID())){
                                System.out.println("Valid ID");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")){
                            System.out.println("Not Valid ID");
                            continue;
                        }
                        String enrolStudent = studentId;
                        while (loop){
                            System.out.println("Please enter semester: (2020B - 2021A)");
                            studentId = scanner.next();
                            valid = "";
                            ArrayList<String> semester1 = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
                            for (String s : semester1) {
                                if (!studentId.equalsIgnoreCase(s)) {
                                    System.out.println("Valid Semester");
                                    valid = "valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("valid")){
                                System.out.println("Not Valid Semester");
                                continue;
                            }
                            String exist = "";
                            String enrolSemester = studentId;
                            ArrayList<String> enrolCourses = new ArrayList<>();
                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) && enrolSemester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                    exist = "exist";
                                    enrolCourses.add(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                }
                            }
                            if (!exist.equalsIgnoreCase("exist")){
                                System.out.println("There are no enrolment for Student " + enrolStudent + "in" + enrolSemester);
                                break;
                            }
                            System.out.println("""
                            Would you like to add or delete enrolment
                            1) Add enrolment
                            2) Delete enrolment
                            """);
                            String option1 = scanner.next();
                            switch (option1){
                                case "1":
                                    while(loop){
                                        System.out.println("Please choose a course to enrol: ");
                                        for (int i = 0; i < course.courseArray.size(); i++) {
                                            System.out.println(course.courseArray.get(i));
                                        }
                                        String courseID = scanner.next();
                                        exist = "";
                                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                            if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                enrolSemester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                exist = "exist";
                                                break;
                                            }
                                        }
                                        if (exist.equalsIgnoreCase("exist")) {
                                            System.out.println("Enrolment Already Existed");
                                            System.out.println("Please Choose Another Course");
                                            continue;
                                        }
                                        StudentEnrolment studentEnrolment1 = new StudentEnrolment(enrolStudent, courseID, enrolSemester);
                                        studentEnrolment.updateEnrolmentadd(studentEnrolment1);
                                        System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                        loop = false;
                                        System.out.println("Successfully update enrolment for " + enrolStudent + " for semester " + enrolSemester);
                                    }


                                case "2" :
                                    while (loop) {
                                        System.out.println("Please choose a course you want to delete:");
                                        for (String enrolCours : enrolCourses) {
                                            System.out.println(enrolCours);
                                        }
                                        String courseID = scanner.next();
                                        String delete = "";
                                        for (String enrolCours : enrolCourses) {
                                            if (courseID.equalsIgnoreCase(enrolCours)) {
                                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                                        enrolCours.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                                        enrolSemester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                                        studentEnrolment.updateEnrolmentdelete(StudentEnrolmentManager.studentEnrolment.get(i));
                                                        System.out.println(StudentEnrolmentManager.studentEnrolment.size());
                                                        delete = "delete";
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (delete.equalsIgnoreCase("delete")) {
                                            System.out.println("Updated 1 enrollment:\n");
                                            loop = false;
                                        }
                                        else {
                                            System.out.println("Cannot find enrolment!");
                                        }
                                    }
                                }

                        }
                    }
                }



                case "3" ->{
                    loop = true;
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
                        }
                        if (!valid.equalsIgnoreCase("valid")){
                            System.out.println("Not Valid ID");
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
                            }
                            if (!valid.equalsIgnoreCase("valid")){
                                System.out.println("Not Valid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop){
                                System.out.println("Please enter semester: (2020B - 2021A)");
                                studentID = scanner1.next();
                                valid = "";
                                ArrayList<String> semester1 = new ArrayList<>(Arrays.asList("2020B","2020C","2021A"));
                                for (String s : semester1) {
                                    if (!studentID.equalsIgnoreCase(s)) {
                                        System.out.println("Valid Semester");
                                        valid = "valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("valid")){
                                    System.out.println("Not Valid Semester");
                                    continue;
                                }
                                String delete = "";
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                            enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                            studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                        studentEnrolment.deleteEnrolment(StudentEnrolmentManager.studentEnrolment.get(i));
                                        delete = "delete";
                                        System.out.println("Successfully delete enrolment!");
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



                case "4" -> {
                    loop = true;
                    while (loop) {
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
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid ID");
                            continue;
                        }
                        System.out.println("Please enter semester: ");
                        String Semester = scanner1.next();
                        valid = "";
                        for (String s : semester) {
                            if (Semester.equalsIgnoreCase(s)) {
                                System.out.println("Valid Semester");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid Semester");
                            continue;
                        }
                        int count = 0;
                        System.out.println("Course of " + studentID + ":");
                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                            if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                count += 1;
                            }
                        }
                        if (count == 0){
                            System.out.println("There are no course which " + studentID + " enrol in");
                        }
                        else{
                            for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                if (studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                    Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                    System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                                }
                            }
                        }
                        loop = false;
                    }
                }
                case "5" -> {
                    loop = true;
                    while (loop) {
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
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid Course ID");
                            continue;
                        }
                        System.out.println("Please enter semester: ");
                        String Semester = scanner1.next();
                        valid = "";
                        for (String s : semester) {
                            if (Semester.equalsIgnoreCase(s)) {
                                System.out.println("Valid Semester");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid Semester");
                            continue;
                        }
                        System.out.println("Students in course: " + courseID);
                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                            if (courseID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                    Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getStudent());
                            }
                        }
                        loop = false;
                    }
                }
                case "6" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("Print All Course In One Semester: \n" +
                                "Please enter semester: ");
                        String Semester = scanner1.next();
                        String valid = "";
                        for (String s : semester) {
                            if (Semester.equalsIgnoreCase(s)) {
                                System.out.println("Valid Semester");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid Semester");
                            continue;
                        }
                        System.out.println("Course in Semester: " + Semester);
                        for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                            if (Semester.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                System.out.println(StudentEnrolmentManager.studentEnrolment.get(i).getCourse());
                            }
                        }
                        loop = false;
                    }
                }
                case "7" ->
                    studentEnrolment.getAll();

                case "8" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("Print one enrolment: \n" +
                                "Please enter student ID: ");
                        String studentID = scanner1.next();
                        String valid = "";
                        for (int i = 0; i < student.studentArray.size(); i++) {
                            if (studentID.equalsIgnoreCase(student.studentArray.get(i).getID())) {
                                System.out.println("Valid ID");
                                valid = "valid";
                                break;
                            }
                        }
                        if (!valid.equalsIgnoreCase("valid")) {
                            System.out.println("Not Valid ID");
                            continue;
                        }
                        String enrolStudent = studentID;
                        while (loop) {
                            System.out.println("Please enter course ID: ");
                            studentID = scanner1.next();
                            valid = "";
                            for (int i = 0; i < course.courseArray.size(); i++) {
                                if (studentID.equalsIgnoreCase(course.courseArray.get(i).getCourseID())) {
                                    System.out.println("Valid Course ID");
                                    valid = "valid";
                                    break;
                                }
                            }
                            if (!valid.equalsIgnoreCase("valid")) {
                                System.out.println("Not Valid Course ID");
                                continue;
                            }
                            String enrolCourse = studentID;
                            while (loop) {
                                System.out.println("Please enter semester: (2020B - 2021A)");
                                studentID = scanner1.next();
                                valid = "";
                                ArrayList<String> semester1 = new ArrayList<>(Arrays.asList("2020B", "2020C", "2021A"));
                                for (String s : semester1) {
                                    if (!studentID.equalsIgnoreCase(s)) {
                                        System.out.println("Valid Semester");
                                        valid = "valid";
                                        break;
                                    }
                                }
                                if (!valid.equalsIgnoreCase("valid")) {
                                    System.out.println("Not Valid Semester");
                                    continue;
                                }
                                for (int i = 0; i < StudentEnrolmentManager.studentEnrolment.size(); i++) {
                                    if (enrolStudent.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getStudent()) &&
                                        enrolCourse.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getCourse()) &&
                                        studentID.equalsIgnoreCase(StudentEnrolmentManager.studentEnrolment.get(i).getSemester())) {
                                        studentEnrolment.getOne(i);
                                        loop = false;
                                        break;
                                    }
                                }

                            }
                        }
                    }
                }
                case "9" -> {
                    System.out.println("""
                            Print all info (student, course or enrolment):
                            1) All student info
                            2) All course info
                            3) All enrolment\s
                            """);
                    String option1 = scanner.next();
                    switch (option1){
                        case "1" -> student.getAllStudents();
                        case "2" -> course.getAllCourses();
                        case "3" -> studentEnrolment.getAll();
                    }
                }
                case "10" -> condition = "quit";
            }
        }
    }
}
