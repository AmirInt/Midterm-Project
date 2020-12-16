import java.util.ArrayList;
import java.util.Timer;

public class Course {

    private Subjects subject;
    private String description;
    private ArrayList<Course> prerequisites;
    private Teacher teacher;
    private Days day;
    private Times time;
    private int credits;
    private int capacity;
    private int attendants;

    public Course(Subjects subject, String description, ArrayList<Course> prerequisites,
                  Teacher teacher, Days day, Times time, int credits, int capacity) {
        this.subject = subject;
        this.description = description;
        this.prerequisites = prerequisites;
        this.teacher = teacher;
        this.day = day;
        this.time = time;
        this.credits = credits;
        this.capacity = capacity;
        attendants = 0;
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

    public int getCredits() {
        return credits;
    }

    public int getAttendants() {
        return attendants;
    }

    public int getCapacity() {
        return capacity;
    }
}
