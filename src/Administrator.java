public class Administrator extends Member {

    private static Administrator administrator = null;

    private Administrator(String userName, String passWord) {
        super(userName, passWord);
    }

    public static Administrator getInstance(String userName, String passWord) {
        if(administrator == null)
            administrator = new Administrator(userName, passWord);
        return administrator;
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
