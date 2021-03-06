package hlrv.flybook;

public class PersonPOJO {

    /*
     * email address of the user
     */
    private String email;

    /*
     * Name of the user
     */
    private String name;

    /*
     * Is this a good way to handle password field?
     */
    private String password;

    /**
     * The constructor used to create a new user
     * 
     * How should password data be handled?
     * 
     * @param email
     * @param name
     * @param password
     * @param admin
     */
    public PersonPOJO(String email, String name, String password) {

        this.email = email;
        this.name = name;
        this.password = password;

    }

    /**
     * Getter for email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for name
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for password
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for users email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter for user name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Email: " + email + " Password: " + password;
    }

}