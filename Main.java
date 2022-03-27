import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Student student = new Student(123456, "ABV", "12/12/2000");
//        student.studentArray.add(student.toString());
//        for(int i=0; i < student.studentArray.size(); i++){
//            System.out.println(student.studentArray.get(i).toString());
//        }
        addStudent();
        System.out.println("Do you want to continue?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int request = scanner.nextInt();
        if(request == 1) {

        }
        if(request == 2) {
            System.out.println("Stop adding student");
        }

    }

    public static void addStudent(){
        System.out.println("1. Add student");
        System.out.println("2. Print student");
        Student student = new Student();

        int input = scanner.nextInt();
        if(input == 1) {
            System.out.println("Please enter your id: ");
            int studentID = scanner.nextInt();
            System.out.println("Please enter your name: ");
            String studentName = scanner.next();
            System.out.println("Please enter your date of birth: ");
            String studentDOB = scanner.next();

            Student student1 = new Student(studentID, studentName, studentDOB);
            student.studentArray.add(student1);
        }
        if(input == 2){
            for(int i=0; i < student.studentArray.size(); i++){
                System.out.println( student.studentArray.get(i) );
            }
        }
        else {
            System.out.println("Error");
        }
    }
}
