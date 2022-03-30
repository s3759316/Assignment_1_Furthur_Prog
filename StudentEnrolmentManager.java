import java.util.ArrayList;

public interface StudentEnrolmentManager {

        void addEnrolment(StudentEnrolment newEnrolment);
        void updateEnrolment(StudentEnrolment updateData, StudentEnrolment update);
        void deleteEnrolment(StudentEnrolment enrolment);
        void getOne();
        void getAll();
        ArrayList<StudentEnrolment> studentEnrolment = new ArrayList<>();

}
