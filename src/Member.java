public class Member {

    private String userName;
    private String password;

    public Member(String userName, String password) {
        this.userName = userName;
        if(password.length() > 8)
            this.password = password;
    }

    public void setPassword(String password) {
        if(password.length() > 8)
            this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
