package com.gulag.entity;

public enum Role {
    ADMIN, MANAGER, USER, GUEST;

    public String getName() {
        return name();
    }
}
