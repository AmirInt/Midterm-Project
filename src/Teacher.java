import java.util.ArrayList;

/**
 * Class Teacher represents a single Teacher in the system
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Teacher extends Member {

    private ArrayList<Course> teacherCourses;

    /**
     * Instantiates this class
     * @param userName The teacher's username
     * @param password The teacher's password
     */
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

    /**
     * Adda a new course to the list of the courses
     * @param course The new course
     */
    public void addToCourses(Course course) {
        teacherCourses.add(course);
    }

    /**
     * @return this teacher's list of current courses
     */
    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    /**
     * Removes the given course from the teacher's list of courses
     * @param course The ended course
     */
    public void removeCourse(Course course) {
        Course crs = null;
        for (Course current:
             teacherCourses) {
            if(current.equals(course))
                crs = current;
        }
        if(crs != null)
            teacherCourses.remove(crs);
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
