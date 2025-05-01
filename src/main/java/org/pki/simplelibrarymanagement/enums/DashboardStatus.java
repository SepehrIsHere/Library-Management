package org.pki.simplelibrarymanagement.enums;

import lombok.Getter;

@Getter
public enum DashboardStatus {

    ACTIVE(1, "Active"),
    SUSPENDED(2, "Suspended"),
    DEACTIVATED(3, "Deactivated");

    private Integer id;
    private String name;

    DashboardStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
