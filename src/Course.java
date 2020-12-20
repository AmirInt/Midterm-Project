import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Class Student represents a single student in the system
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Course implements Serializable {

    private Subjects subject;
    private String description;
    private ArrayList<Subjects> prerequisites;
    private Teacher teacher;
    private Days day;
    private Times time;
    private int credits;
    private int capacity;
    private int attendants;
    private ArrayList<Student> courseStudents;

    /**
     * Instantiates this class
     */
    public Course() {
        attendants = 0;
        courseStudents = new ArrayList<>();
        prerequisites = new ArrayList<>();
    }

    /**
     * Sets this course's subject
     * @param subject The subject
     */
    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    /**
     * @return this course's teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @return this course's subject
     */
    public Subjects getSubject() {
        return subject;
    }

    /**
     * Sets this course's day
     * @param day The day
     */
    public void setDay(Days day) {
        this.day = day;
    }

    /**
     * @return this course's day
     */
    public Days getDay() {
        return day;
    }

    /**
     * Sets this course's time
     * @param time The time
     */
    public void setTime(Times time) {
        this.time = time;
    }

    /**
     * @return this course's time
     */
    public Times getTime() {
        return time;
    }

    /**
     * Sets this course's number of credits
     * @param credits The number of credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * @return this course's number of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @return this course's number of attendants
     */
    public int getAttendants() {
        return attendants;
    }

    /**
     * Sets this course's capacity
     * @param capacity The capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return this course's capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets this course's description
     */
    public void setDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Subject: ").append(subject).append("\n");
        stringBuilder.append("Teacher: ").append(teacher.getUserName()).append("\n");
        stringBuilder.append("Day: ").append(day).append(" Time: ");
        String timeString;
        switch (time) {
            case _8_10:
                timeString = "8 - 10";
                break;
            case _10_12:
                timeString = "10 - 12";
                break;
            default:
                timeString = "14 - 16";
        }
        stringBuilder.append(timeString).append("\n").append(" Credits: ").append(credits).append(" Capacity: ").append(capacity);
        stringBuilder.append("\n").append(" Attendants: ").append(attendants).append("\n");
        if(prerequisites != null) {
            stringBuilder.append("Prerequisites:\n");
            for (Subjects subject :
                    prerequisites)
                stringBuilder.append(subject).append(", ");
        }
        description = stringBuilder.toString();
    }

    /**
     * @return this course's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return this course's attending student's
     */
    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    /**
     * Adds a student to this course
     * @param student New Student
     */
    public void addStudent(Student student) {
        courseStudents.add(student);
        ++attendants;
        setDescription();
    }

    /**
     * Sets this course's prerequisites
     * @param prerequisites The prerequisites
     */
    public void setPrerequisites(ArrayList<Subjects> prerequisites) {
        if(prerequisites != null)
            this.prerequisites = prerequisites;
    }

    /**
     * @return this course's prerequisites
     */
    public ArrayList<Subjects> getPrerequisites() {
        return prerequisites;
    }

    /**
     * Sets this course's teacher
     * @param teacher The teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Overrides the equals method in class object
     * @param o The other object to be compared with
     * @return true if these course's are run by the same teacher and have
     * the same day and time of holding
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return teacher != null && course.teacher != null &&
                teacher.equals(course.teacher) &&
                day == course.day &&
                time == course.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, day, time);
    }
}