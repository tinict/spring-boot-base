package com.bvtw.domain.enums;

public enum EAppointmentStatus {
    PENDING("PENDING"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED");

    private final String value;

    EAppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean existEAppointmentStatus(String name) {
        for (EAppointmentStatus eAppointmentStatus : values()) {
            if (eAppointmentStatus.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static EAppointmentStatus getEAppointmentStatusByName(String name) {
        for (EAppointmentStatus EAppointmentStatus : values()) {
            if (EAppointmentStatus.getValue().equals(name)) {
                return EAppointmentStatus;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
