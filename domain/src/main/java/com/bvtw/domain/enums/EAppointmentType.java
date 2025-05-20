package com.bvtw.domain.enums;

public enum EAppointmentType {
    SERVICE("SERVICE"),
    PACKAGE("PACKAGE");


    private final String value;

    EAppointmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean existEAppointmentType(String name) {
        for (EAppointmentType eAppointmentType : values()) {
            if (eAppointmentType.getValue().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static EAppointmentType getEAppointmentTypeByName(String name) {
        for (EAppointmentType eAppointmentType : values()) {
            if (eAppointmentType.getValue().equals(name)) {
                return eAppointmentType;
            }
        }
        throw new IllegalArgumentException("Please re-enter");
    }
}
