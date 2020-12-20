import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Class Student represents a single student in the system
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Student extends Member {

    private float average;
    private float balance;
    private HashMap<Course, Float> studentCourses;
    private HashMap<Course, Float> pastCourses;
    private int currentCredits;
    private int totalCredits;
    private boolean[][] scheduledMeals;

    /**
     * Instanciates this class calling the super method
     * @param userName User's username
     * @param password User's password
     */
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

    /**
     * Calculates this student's average grade
     * @param course The course that has just ended
     * @param courseGrade The course grade, given by the teacher
     */
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

    /**
     * @return this student's average grade
     */
    public float getAverage() {
        return average;
    }

    /**
     * Set's this student's credit
     * @param credits The credit
     */
    public void setBalance(float credits) {
        this.balance = credits;
    }

    /**
     * @return this student's credit
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Adds a course to the student's course list
     * @param selectedCourse The course this student has selected in the
     * course selection module
     */
    public void addToCourses(Course selectedCourse) {
        studentCourses.put(selectedCourse, (float) 0);
    }

    /**
     * @return this student's list of current courses
     */
    public int getCurrentCredits() {
        return currentCredits;
    }

    /**
     * Sets this student's total passed credits
     * @param totalCredits The total credits
     */
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * @return this student's current courses
     */
    public HashMap<Course, Float> getStudentCourses() {
        return studentCourses;
    }

    /**
     * @return this student's passed courses
     */
    public HashMap<Course, Float> getPastCourses() {
        return pastCourses;
    }

    /**
     * Adds the ended course to list of the passed courses,
     * removing it from the current courses and calculating the
     * average
     * @param pastCourse The ended courses
     */
    public void addToPastCourses(Course pastCourse) {
        float grade = getGrade(pastCourse);
        pastCourses.put(pastCourse, grade);
        removeCurrentCourse(pastCourse);
        calculateAverage(pastCourse, grade);
    }

    /**
     * @param pastCourse The ended course
     * @return the ended courses grade
     */
    private float getGrade(Course pastCourse) {
        for (Map.Entry<Course, Float> entry:
             studentCourses.entrySet()) {
            if(entry.getKey().equals(pastCourse))
                return entry.getValue();
        }
        return -1;
    }

    /**
     * Removes the ended course from the list of the current courses
     * @param pastCourse The ended course
     */
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

    /**
     * Sets all the reserved scheduled meals to false
     * in the beginning of the programme
     */
    private void setAllFalse() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                scheduledMeals[i][j] = false;
            }
        }
    }

    /**
     * Reserves the food for a specific day and meal of the week
     * @param day The day
     * @param meal The meal
     * @param price The meal price
     */
    public void addToReserved(int day, int meal, float price) {
        scheduledMeals[day][meal] = true;
        balance -= price;
    }

    /**
     * Un-reserves a selected meal
     * @param day The day
     * @param meal The meal
     * @param price The meal price
     */
    public void removeReserved(int day, int meal, float price) {
        if(scheduledMeals[day][meal]) {
            scheduledMeals[day][meal] = false;
            balance += price;
        }
    }

    /**
     * Checks if a certain meal is reserved
     * @param day The day
     * @param meal The meal
     * @return true if it is reserved
     */
    public boolean isReserved(int day, int meal) {
        return scheduledMeals[day][meal];
    }

    /**
     * @return the list of the reserved meals of the week
     */
    public boolean[][] getScheduledMeals() {
        return scheduledMeals;
    }

    /**
     * Sets all the scheduled meals to false when the admin resets
     * the scheduled refectory meals
     */
    public void clearScheduledMeals() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                scheduledMeals[i][j] = false;
            }
        }
    }

    /**
     * Checks for the student's prerequisites to see if the student has passed
     * taken by the time the course is selected
     * @param selectedCourse The course to be selected
     * @return true if the student satisfies the prerequisites
     */
    public boolean arePrerequisitesTaken(Course selectedCourse) {
        boolean isPassed;
        boolean qualified = true;
        HashSet<Subjects> takenSubjects = new HashSet<>();
        for (Course course:
                pastCourses.keySet()) {
            takenSubjects.add(course.getSubject());
        }
        for (Course course:
                studentCourses.keySet()) {
            takenSubjects.add(course.getSubject());
        }
        if(selectedCourse.getPrerequisites() != null && selectedCourse.getPrerequisites().size() != 0)
            for (Subjects subject:
                    selectedCourse.getPrerequisites()) {
                isPassed = false;
                for (Subjects pastSubject:
                        takenSubjects)
                    if(subject.equals(pastSubject)) {
                        isPassed = true;
                        break;
                    }
                qualified &= isPassed;
            }
        return qualified;
    }

    /**
     * Checks the student course schedule to prevent the selection of
     * coinciding courses
     * @param course The course
     * @return true if the student's time is filled at the time of the course
     */
    public boolean isTimeFilled(Course course) {
        for (Course studentCourse:
                studentCourses.keySet())
            if(studentCourse.getDay() == course.getDay()
                    && studentCourse.getTime() == course.getTime())
                return true;
        return false;
    }

    /**
     * Checks if the course to be selected is previously taken by the this student
     * @param selectedCourse The course to be selected
     * @return true if this student has already passed or taken the course
     */
    public boolean isPreviouslyTaken(Course selectedCourse) {
        for (Course studentPastCourse:
                studentCourses.keySet()) {
            if(selectedCourse.getSubject() == studentPastCourse.getSubject()) {
                return true;
            }
        }
        for (Course studentCourse:
                studentCourses.keySet()) {
            if(selectedCourse.getSubject() == studentCourse.getSubject()) {
                return true;
            }
        }
        return false;
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
