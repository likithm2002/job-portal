package com.crud.jobportal.module.jobapplication.enums;

public enum JobApplicationStatus {
    APPLIED(0),
    SHORTLISTED(1),
    INTERVIEW(2),
    OFFERED(3);

    private final int ordinalValue;

    JobApplicationStatus(int ordinalValue) {
        this.ordinalValue =ordinalValue;
    }

    public int getOrdinalValue() {
        return ordinalValue;
    }

    public static JobApplicationStatus fromOrdinal(int ordinal) {
        for (JobApplicationStatus status : values()) {
            if (status.ordinalValue == ordinal) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
    }
}

