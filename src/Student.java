import java.util.HashMap;
import java.util.Map;

public class Student extends Member {

    private float average;
    private float balance;
    private HashMap<Course, Float> studentCourses;
    private HashMap<Course, Float> pastCourses;
    private int currentCredits;
    private int totalCredits;
    private boolean[][] scheduledMeals;

    public Student(String userName, char[] password) {
        super(userName, password);
        totalCredits = 0;
        average = 0;
        balance = 0;
        currentCredits = 0;
        studentCourses = new HashMap<>();
        pastCourses = new HashMap<>();
        scheduledMeals = new boolean[7][2];
        setAllFalse();
    }

    @Override
    public void setPassword(char[] password) {
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    public void calculateAverage(Course course, Float courseGrade) {
        average = average * totalCredits + course.getCredits() * courseGrade;
        setTotalCredits(totalCredits + course.getCredits());
        average /= totalCredits;
    }

    @Override
    public char[] getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public float getAverage() {
        return average;
    }

    public void setBalance(float credits) {
        this.balance = credits;
    }

    public float getBalance() {
        return balance;
    }

    public void addToCourses(Course selectedCourse) {
        studentCourses.put(selectedCourse, (float) 0);
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public HashMap<Course, Float> getStudentCourses() {
        return studentCourses;
    }

    public HashMap<Course, Float> getPastCourses() {
        return pastCourses;
    }

    public void addToPastCourses(Course pastCourse) {
        float grade = getGrade(pastCourse);
        pastCourses.put(pastCourse, grade);
        removeCurrentCourse(pastCourse);
        calculateAverage(pastCourse, grade);
    }

    private float getGrade(Course pastCourse) {
        for (Map.Entry<Course, Float> entry:
             studentCourses.entrySet()) {
            if(entry.getKey().equals(pastCourse))
                return entry.getValue();
        }
        return -1;
    }

    private void removeCurrentCourse(Course pastCourse) {
        Map.Entry<Course, Float> courseFloatEntry = null;
        for (Map.Entry<Course, Float> entry:
                studentCourses.entrySet()) {
            if(entry.getKey().equals(pastCourse))
                courseFloatEntry = entry;
        }
        if(courseFloatEntry != null)
            studentCourses.remove(courseFloatEntry.getKey());
    }

    private void setAllFalse() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                scheduledMeals[i][j] = false;
            }
        }
    }

    public void addToReserved(int day, int meal, float price) {
        scheduledMeals[day][meal] = true;
        balance -= price;
    }

    public void removeReserved(int day, int meal, float price) {
        if(scheduledMeals[day][meal]) {
            scheduledMeals[day][meal] = false;
            balance += price;
        }
    }

    public boolean isReserved(int day, int meal) {
        return scheduledMeals[day][meal];
    }

    public boolean[][] getScheduledMeals() {
        return scheduledMeals;
    }

    public void clearScheduledMeals() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                scheduledMeals[i][j] = false;
            }
        }
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
