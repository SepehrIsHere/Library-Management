package org.pki.simplelibrarymanagement.entities;

import com.lib.demo.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("Member")
    private Role role;
}
