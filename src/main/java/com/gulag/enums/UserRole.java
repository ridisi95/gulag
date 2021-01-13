package com.gulag.enums;

public enum UserRole {
    ADMIN, MANAGER, USER, GUEST;

    public String getName() {
        return name();
    }
}
