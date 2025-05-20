package com.bvtw.domain.enums;


public enum EUserRole {
    ROLE_ADMIN("ADMIN"),
    ROLE_CLIENT("CLIENT"),
    ROLE_CASHIER("CASHIER"),
    ROLE_STAFF("STAFF"),
    ROLE_CUSTOMER("CUSTOMER"),
    ROLE_ACCOUNTANT("ACCOUNTANT"),
    ROLE_MANAGER("MANAGER");

    private final String value;

    EUserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static EUserRole getEUserRoleByName(String name) {
        for (EUserRole eUserRole : values()) {
            if (eUserRole.getValue().equals(name)) {
                return eUserRole;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }

}
