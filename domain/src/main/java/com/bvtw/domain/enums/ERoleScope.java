package com.bvtw.domain.enums;

public enum ERoleScope {
    GLOBAL("GLOBAL"),
    LOCAL("LOCAL");

    private final String value;

    ERoleScope(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
