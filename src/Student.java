public class Student extends Member {

    private float average;
    private int credits;

    public Student(String userName, String password) {
        super(userName, password);
        average = 0;
        credits = 0;
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    public void setAverage(float average) {
        if(average <= 20 & average >= 0)
            this.average = average;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public float getAverage() {
        return average;
    }

    public int getCredits() {
        return credits;
    }
}
