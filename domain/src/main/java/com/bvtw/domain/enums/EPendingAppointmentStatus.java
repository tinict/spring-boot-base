package com.bvtw.domain.enums;

public enum EPendingAppointmentStatus {
    PENDING("PENDING"),
    EXPIRED("EXPIRED"),
    COMPLETED("COMPLETED");

    private final String value;

    EPendingAppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean existEPendingAppointmentStatus(String name) {
        for (EPendingAppointmentStatus status : values()) {
            if (status.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static EPendingAppointmentStatus getEPendingAppointmentStatusByName(String name) {
        for (EPendingAppointmentStatus status : values()) {
            if (status.getValue().equals(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
