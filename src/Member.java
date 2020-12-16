import java.util.Objects;

public class Member {

    private String userName;
    private char[] password;

    public Member(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    public void setPassword(char[] password) {
        if(password.length > 8)
            this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return userName.equals(member.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
