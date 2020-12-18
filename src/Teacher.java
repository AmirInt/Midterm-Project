import java.util.ArrayList;

public class Teacher extends Member {

    private ArrayList<Course> teacherCourses;

    public Teacher(String userName, char[] password) {
        super(userName, password);
        teacherCourses = new ArrayList<>();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public void setPassword(char[] password) {
        super.setPassword(password);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public char[] getPassword() {
        return super.getPassword();
    }

    public void addToCourses(Course course) {
        teacherCourses.add(course);
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
