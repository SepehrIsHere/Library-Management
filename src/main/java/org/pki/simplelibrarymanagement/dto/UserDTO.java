package org.pki.simplelibrarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.pki.simplelibrarymanagement.enums.Gender;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String nationalId;
    private String phoneNumber;
    private LocalDate birthDate;
    private Gender gender;
}
