import java.util.ArrayList;
import java.util.Timer;

public class Course {

    private Subjects subject;
    private String description;
    private ArrayList<Course> prerequisites;
    private Teacher teacher;
    private Days day;
    private Times time;

    public Course(Subjects subject, String description, ArrayList<Course> prerequisites, Teacher teacher, Days day, Times time) {
        this.subject = subject;
        this.description = description;
        this.prerequisites = prerequisites;
        this.teacher = teacher;
        this.day = day;
        this.time = time;
    }

    public Subjects getSubject() {
        return subject;
    }

    public Days getDay() {
        return day;
    }

    public Times getTime() {
        return time;
    }
}
