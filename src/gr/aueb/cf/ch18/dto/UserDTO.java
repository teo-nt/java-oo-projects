package gr.aueb.cf.ch18.dto;

/**
 * DTO for an account holder.
 */
public class UserDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String ssn;

    public UserDTO() {

    }

    public UserDTO(String firstname, String lastname, String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public UserDTO(UserDTO userDTO) {
        this.firstname = userDTO.firstname;
        this.lastname = userDTO.lastname;
        this.ssn = userDTO.ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
