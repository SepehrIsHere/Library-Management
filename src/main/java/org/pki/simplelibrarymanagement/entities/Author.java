package org.pki.simplelibrarymanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @NotNull(message = " cant be null")
    @NotBlank(message = " cant be blank")
    private String firstName;

    @NotNull(message = " cant be null")
    @NotBlank(message = " cant be blank")
    private String lastName;

    @Email(message = "Email is not valid")
    @NotNull(message = "email cant be null")
    private String email;

    @OneToMany
    private Set<Book> books;

}
