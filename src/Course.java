import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
    private HashMap<Student, Float> courseStudents;

    public Course() {
        attendants = 0;
        courseStudents = new HashMap<>();
        prerequisites = new ArrayList<>();
        courseStudents = new HashMap<>();
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public Days getDay() {
        return day;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public Times getTime() {
        return time;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public int getAttendants() {
        return attendants;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

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

    public String getDescription() {
        return description;
    }

    public HashMap<Student, Float> getCourseStudents() {
        return courseStudents;
    }

    public void addStudent(Student student) {
        courseStudents.put(student, (float) 0);
        ++attendants;
        setDescription();
    }

    public void setPrerequisites(ArrayList<Subjects> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public ArrayList<Subjects> getPrerequisites() {
        return prerequisites;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
