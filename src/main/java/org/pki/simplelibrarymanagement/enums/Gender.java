package org.pki.simplelibrarymanagement.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE(1, "male"),
    FEMALE(2, "female"),
    NONBINARY(3, "non binary");

    private Integer code;
    private String title;

    Gender(Integer code, String title) {
        this.code = code;
        this.title = title;
    }
}
