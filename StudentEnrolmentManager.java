import java.util.ArrayList;

public interface StudentEnrolmentManager {

        void addEnrolment(StudentEnrolment newEnrolment);
        void updateEnrolmentadd(StudentEnrolment updateAdd);
        void updateEnrolmentdelete(StudentEnrolment updateDelete);
        void deleteEnrolment(StudentEnrolment delete);
        void getOne(int One);
        void getAll();
        ArrayList<StudentEnrolment> studentEnrolment = new ArrayList<>();

}
