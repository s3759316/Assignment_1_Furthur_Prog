import java.util.ArrayList;

public class Course {
    private String courseID;
    private String name;
    private String credit;

    ArrayList<Course> courseArray = new ArrayList<>();

    public Course() {}

    public Course(String courseID, String name, String credit) {
        this.courseID = courseID;
        this.name = name;
        this.credit = credit;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {      // Convert course information to string in order to print
        return "id: " + courseID + " " +
                "| name: " + name + " " +
                "| noCredits: " + credit;
    }

    public void getAllCourses() {
        for (Course course : courseArray) {
            System.out.println(course.toString());
        }
    }
}
