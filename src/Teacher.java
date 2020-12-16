public class Teacher extends Member {

    public Teacher(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
