import java.util.ArrayList;

public class StudentEnrolment implements StudentEnrolmentManager{

    private String student;
    private String course;
    private String semester;

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
    public void deleteEnrolment(StudentEnrolment enrolment) {
        studentEnrolment.remove(enrolment);
        System.out.println("\nDeleted 1 enrollment\n");
    }

//    @Override
//    public ArrayList<StudentEnrolment> getAllEnrolments() {
//        return this.enrolmentList;
//    }
}

