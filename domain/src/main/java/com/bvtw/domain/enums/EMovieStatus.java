package com.bvtw.domain.enums;

public enum EMovieStatus {

    COMING("COMING"),
    PLAYING("PLAYING"),
    SPECIAL("SPECIAL"),
    BLOCK("BLOCK");

    private final String value;

    EMovieStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
