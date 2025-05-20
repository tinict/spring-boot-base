package com.bvtw.domain.enums;

public enum EChairStatus {
    EMPTY("EMPTY"),
    BUSY("BUSY");

    private final String value;

    EChairStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
