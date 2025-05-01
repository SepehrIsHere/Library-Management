package org.pki.simplelibrarymanagement.entities;

import com.lib.demo.enums.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Book extends BaseEntity {

    @NotBlank(message = "title cant be blank")
    @NotNull(message = "title cant be null")
    private String title;

    @ColumnDefault("0")
    private String isbn;

    @Enumerated(EnumType.STRING)
    private List<Genre> genre;

    @OneToMany
    private Set<Author> author;

    private boolean isBorrowed;


}
