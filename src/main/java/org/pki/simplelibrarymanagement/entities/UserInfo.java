package org.pki.simplelibrarymanagement.entities;

import com.lib.demo.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInfo extends BaseEntity {

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
}
