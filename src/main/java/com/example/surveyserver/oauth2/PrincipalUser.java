package com.example.surveyserver.oauth2;


public class PrincipalUser {
    private final String employeeId;
    private final String displayName;
    private final String email;

    public PrincipalUser(String employeeId, String displayName, String email) {
        this.employeeId = employeeId;
        this.displayName = displayName;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PrincipalUser{" +
                "employeeId='" + employeeId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
