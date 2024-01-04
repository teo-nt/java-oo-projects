package gr.aueb.cf.ch13;

/**
 * Defines a {@link User} with the following fields:
 * {@link #id}, {@link #firstname}, {@link #lastname} and contains
 * accessor and mutator methods.
 *
 * @since 1.0
 * @version 1.0
 * @author thodoris
 */
public class User {
    private Long id;
    private String firstname;
    private String lastname;

    /**
     * Default constructor of {@link User}.
     */
    public User() {

    }

    /**
     * Overloaded constructor of {@link User}.
     *
     * @param id
     *          the input {@link #id}.
     * @param firstname
     *          the input {@link #firstname}.
     * @param lastname
     *          the input {@link #lastname}.
     */
    public User(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Gets the {@link #id} of {@link User} instance.
     *
     * @return
     *      user's id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the {@link #id} of {@link User} instance.
     *
     * @param id
     *      user's id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the {@link #firstname} of {@link User} instance.
     *
     * @return
     *      user's firstname.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the {@link #firstname} of {@link User} instance.
     *
     * @param firstname
     *      user's firstname.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the {@link #lastname} of {@link User} instance.
     *
     * @return
     *      user's lastname.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the {@link #lastname} of {@link User} instance.
     *
     * @param lastname
     *      user's lastname.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the state of {@link User} instance.
     *
     * @return
     *      string representing {@link User} instance state.
     */
    public String userToString() {
        return "ID: " + id + ", Firstname: " + firstname + ", Lastname: " + lastname;
    }
}
