package Enums;

public enum RoleCustomer {

    ROLE_CONFIRMATION_ADMINISTRATOR("administrator"), ROLE_CONFIRMATION_MODERATOR("moderator"),
    ROLE_CONFIRMATION_GUEST("guest");

    private String role;

    RoleCustomer(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;

    }


}
