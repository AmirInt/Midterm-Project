
/**
 * Class Administrator represents the unique administrator in the system
 * This class acts as a singleton
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Administrator extends Member {

    private static Administrator administrator = null;

    /**
     * Instantiates this class as a singleton
     * @param userName The username
     * @param passWord The password
     */
    private Administrator(String userName, char[] passWord) {
        super(userName, passWord);
    }

    /**
     * @param userName The initial username
     * @param passWord THe initial password
     * @return A unique instance of this class
     */
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && this.getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
