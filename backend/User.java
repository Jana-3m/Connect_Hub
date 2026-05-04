package backend;

import java.time.LocalDate;

/**
 * USER entity.
 */
public class User {

    public enum Status {ONLINE, OFFLINE}  //possible user status

    private int userId;
    private String email;
    private String username;
    private String password;   // stored as salt:hash
    private LocalDate dateOfBirth;
    private String status;

    //required by Jackson
    public User() {
    }

    public User(String email, String username, String password,
                LocalDate dateOfBirth, String status) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = normaliseStatus(status);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate d) {
        this.dateOfBirth = d;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = normaliseStatus(status);
    }


    private static String normaliseStatus(String raw) {
        if (raw == null) return "offline";
        return raw.equalsIgnoreCase("online") ? "online" : "offline";
    }

    @Override
    public String toString() {
        return username + " (" + email + ") – " + status;
    }
}