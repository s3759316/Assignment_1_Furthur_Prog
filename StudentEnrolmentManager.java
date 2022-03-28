import java.util.ArrayList;
import java.util.Scanner;

public interface StudentEnrolmentManager {

        void addEnrolment(StudentEnrolment newEnrolment);
        void updateEnrolment(StudentEnrolment updateData, StudentEnrolment update);
        void deleteEnrolment(StudentEnrolment enrolment);
        ArrayList<StudentEnrolment> getAllEnrolments();
}
