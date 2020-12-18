import java.util.HashMap;

public class Student extends Member {

    private float average;
    private float balance;
    private HashMap<Course, Integer> studentCourses;
    private HashMap<Course, Integer> pastCourses;
    private int currentCredits;
    private int totalCredits;
    private boolean[][] scheduledMeals;

    public Student(String userName, char[] password) {
        super(userName, password);
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

    public void calculateAverage(Course course, float courseGrade) {
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
        studentCourses.put(selectedCourse, 0);
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public HashMap<Course, Integer> getStudentCourses() {
        return studentCourses;
    }

    public HashMap<Course, Integer> getPastCourses() {
        return pastCourses;
    }

    public void addToPastCourses(Course pastCourse, int grade) {
        pastCourses.put(pastCourse, grade);
        calculateAverage(pastCourse, grade);
    }

    private void setAllFalse() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                scheduledMeals[i][j] = false;
            }
        }
    }

    public void addToReserved(int day, int meal) {
        scheduledMeals[day][meal] = true;
    }

    public boolean isReserved(int day, int meal) {
        return scheduledMeals[day][meal];
    }

    public boolean[][] getScheduledMeals() {
        return scheduledMeals;
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
