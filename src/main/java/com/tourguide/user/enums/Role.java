package com.tourguide.user.enums;

public enum Role {
    GUEST("GUEST"),
    USER("USER"),
    ADMIN("ADMIN"),
    MODERATOR("MODERATOR");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

