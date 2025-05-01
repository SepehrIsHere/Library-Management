package org.pki.simplelibrarymanagement.enums;

import lombok.Getter;

@Getter
public enum Role {
    LIBRARIAN(1, "Librarian"),
    MEMBER(2, "Member"),
    ADMIN(3, "Admin");

    private Integer id;
    private String title;

    Role(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
