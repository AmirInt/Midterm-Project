public class Student extends Member {

    private float average;
    private int credits;

    public Student(String userName, char[] password) {
        super(userName, password);
        average = 0;
        credits = 0;
    }

    @Override
    public void setPassword(char[] password) {
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

    public int getCredits() {
        return credits;
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
