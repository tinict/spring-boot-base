package com.bvtw.domain.enums;

public enum EReAppointmentStatus {
    PENDING("PENDING"),

    CONFIRMED("CONFIRMED"),

    CANCELLED("CANCELLED"),

    COMPLETED("COMPLETED");

    private final String value;

    EReAppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean existEReAppointmentStatus(String name) {
        for (EReAppointmentStatus eReAppointmentStatus : values()) {
            if (eReAppointmentStatus.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static EReAppointmentStatus getEReAppointmentStatusByName(String name) {
        for (EReAppointmentStatus EReAppointmentStatus : values()) {
            if (EReAppointmentStatus.getValue().equals(name)) {
                return EReAppointmentStatus;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
