import java.io.Serializable;
import java.util.Objects;

/**
 * Class Member represents a single member in the system
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Member implements Serializable {

    private String userName;
    private char[] password;

    /**
     * Instantiates this class
     * @param userName The member's username
     * @param password The member's password
     */
    public Member(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Sets this member's password
     * @param password The new password
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    /**
     * Sets this member's username
     * @param userName The new username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return this member's password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * @return this member's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Overrides the equals method comparing only the username and password
     * parametres
     * @param o The other object to be compared with
     * @return true if this member is identical with the other object based on the
     * parametres checked
     */
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
