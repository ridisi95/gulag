package com.gulag.enums;

public enum TournamentRole {
    CREATED, STARTED, ENDED, CANCELED;

    public String getName() {
        return name();
    }
}
