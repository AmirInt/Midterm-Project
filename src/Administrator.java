public class Administrator extends Member {

    private static Administrator administrator = null;

    private Administrator(String userName, char[] passWord) {
        super(userName, passWord);
    }

    public static Administrator getInstance(String userName, char[] passWord) {
        if(administrator == null)
            administrator = new Administrator(userName, passWord);
        return administrator;
    }

    @Override
    public void setPassword(char[] password) {
        super.setPassword(password);
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public char[] getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
