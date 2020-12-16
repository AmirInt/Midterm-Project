public class Teacher extends Member {

    public Teacher(String userName, char[] password) {
        super(userName, password);
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
