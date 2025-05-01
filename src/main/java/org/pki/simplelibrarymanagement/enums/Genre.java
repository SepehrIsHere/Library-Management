package org.pki.simplelibrarymanagement.enums;

import lombok.Getter;

@Getter
public enum Genre {

    // --- Fiction Categories ---
    FANTASY(1, "Fantasy"),
    SCIENCE_FICTION(2, "Science Fiction"),
    MYSTERY(3, "Mystery"),
    THRILLER(4, "Thriller"),
    ROMANCE(5, "Romance"),
    HISTORICAL_FICTION(6, "Historical Fiction"),
    HORROR(7, "Horror"),
    CONTEMPORARY(8, "Contemporary"),
    LITERARY_FICTION(9, "Literary Fiction"),
    ADVENTURE(10, "Adventure"),
    YOUNG_ADULT(11, "Young Adult"),
    CHILDREN(12, "Children's"),
    HUMOR(13, "Humor/Comedy"),
    DYSTOPIAN(14, "Dystopian"),
    PARANORMAL(15, "Paranormal"),
    CRIME(16, "Crime Fiction"),
    GRAPHIC_NOVEL(17, "Graphic Novel/Comic"),

    // --- Non-Fiction Categories ---
    BIOGRAPHY(50, "Biography"),
    AUTOBIOGRAPHY(51, "Autobiography"),
    MEMOIR(52, "Memoir"),
    HISTORY(53, "History"),
    SCIENCE(54, "Science"),
    TECHNOLOGY(55, "Technology"),
    SELF_HELP(56, "Self-Help"),
    PSYCHOLOGY(57, "Psychology"),
    PHILOSOPHY(58, "Philosophy"),
    BUSINESS(59, "Business/Economics"),
    TRAVEL(60, "Travel Writing"),
    COOKBOOKS(61, "Cookbooks/Food"),
    ART_PHOTOGRAPHY(62, "Art/Photography"),
    POLITICS(63, "Politics/Current Affairs"),
    RELIGION_SPIRITUALITY(64, "Religion/Spirituality"),
    EDUCATION(65, "Education"),
    TRUE_CRIME(66, "True Crime"),
    ESSAYS(67, "Essays"),

    // --- Other Categories ---
    POETRY(90, "Poetry"),
    DRAMA(91, "Drama/Play"),
    REFERENCE(92, "Reference"),
    OTHER(99, "Other");

    private Integer id;
    private String name;

    Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
