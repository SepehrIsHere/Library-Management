package org.pki.simplelibrarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.pki.simplelibrarymanagement.enums.Gender;
import org.pki.simplelibrarymanagement.enums.Role;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = User.tableName)
public class User extends BaseEntity {
    public static final String tableName = "USERS";

    @Column(unique = true)
    @NotNull(message = "username cant be null")
    @NotBlank(message = "username cant be blank")
    private String username;

    @NotNull(message = "password cant be null")
    @NotBlank(message = "password cant be blank")
    private String password;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("Member")
    private Role role;

    @NotBlank(message = "firstname cant be blank")
    @NotNull(message = "firstname cant be null")
    private String firstName;

    @NotBlank(message = "lastname cant be blank")
    @NotNull(message = "lastname cant be null")
    private String lastName;

    @Email(message = "Email format is not valid")
    private String email;

    @NotBlank(message = "phone number cant be blank")
    @NotNull(message = "phone number cant be null")
    private String phoneNumber;

    @NotBlank(message = "national id cant be blank")
    @NotNull(message = "national id cant be null")
    private String nationalId;

    @NotNull(message = "gender cant be null")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "birth date cant be null")
    private LocalDate birthDate;
}
