import java.util.ArrayList;

public class Course {
    private String courseID;
    private String name;
    private int credit;

    private ArrayList<Course> courseArray = new ArrayList<Course>();

    public Course() {}

    public Course(String courseID, String name, int credit) {
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ArrayList<Course> getCourseArray() {
        return courseArray;
    }

    public void addCourse(Course course) {
        courseArray.add(course);
    }

    public String toString() {
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
