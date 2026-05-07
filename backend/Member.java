package backend;

import org.json.JSONObject;

/**
 * Represents a user's membership in a Group -- to be implemented**
 * Roles: "Primary Admin" | "Admin" | "Member"
 */
public class Member {

    public enum Role {
        PRIMARY_ADMIN("Primary Admin"), ADMIN("Admin"), MEMBER("Member");

        private final String label;

        Role(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public static Role fromString(String s) {
            for (Role r : values())
                if (r.label.equalsIgnoreCase(s)) return r;
            return MEMBER;
        }
    }

    private User user;
    private String role;

    public Member() {
    }

    public Member(User user, String role) {
        this.user = user;
        this.role = role;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return "Admin".equalsIgnoreCase(role) || "Primary Admin".equalsIgnoreCase(role);
    }
    

    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("userId", user.getUserId());
        j.put("username", user.getUsername());
        j.put("email", user.getEmail());
        j.put("dateOfBirth", user.getDateOfBirth() == null ? "" : user.getDateOfBirth().toString());
        j.put("status", user.getStatus());
        j.put("role", role);
        return j;
    }
}