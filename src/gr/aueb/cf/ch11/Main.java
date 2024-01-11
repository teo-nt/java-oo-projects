package gr.aueb.cf.ch11;

/**
 * Creates two instances of User and UserCredentials classes
 * and the fields of each instance are printed to the console.
 *
 * @author Thodoris
 */
public class Main {

    public static void main(String[] args) {
        User thodoris = new User(1L, "Thodoris", "Ntonas");
        UserCredentials thodCredentials = new UserCredentials(1L, "Teo", "12345");

        System.out.println("{ID: " + thodoris.getId() + ", FIRSTNAME: " + thodoris.getFirstname() +
                            ", LASTNAME: " + thodoris.getLastname() + "}");
        System.out.println("{ID: " + thodCredentials.getId() + ", USERNAME: " + thodCredentials.getUsername() +
                            ", PASSWORD: " + thodCredentials.getPassword() + "}");
    }
}
