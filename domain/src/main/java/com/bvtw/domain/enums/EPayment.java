package com.bvtw.domain.enums;

public enum EPayment {
    ONLINE("ONLINE"),
    OFFLINE("OFFLINE");

    private final String value;

    EPayment(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean existEPayment(String name) {
        for (EPayment payment : values()) {
            if (payment.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static EPayment getEPaymentByName(String name) {
        for (EPayment payment : values()) {
            if (payment.getValue().equals(name)) {
                return payment;
            }
        }
        throw new IllegalArgumentException("Please re-enter a valid payment method.");
    }
}
