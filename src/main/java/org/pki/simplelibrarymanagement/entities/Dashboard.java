package org.pki.simplelibrarymanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.pki.simplelibrarymanagement.enums.DashboardStatus;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Dashboard extends BaseEntity {
    @NotBlank(message = "dashboard name cant be blank")
    @NotNull(message = "dashboard name cant be null")
    private String dashboardName;

    @NotBlank(message = "dashboard id cant be blank")
    @NotNull(message = "dashboard id cant be null")
    private String dashBoardId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @OneToMany
    private Set<Book> borrowedBooks;

    @NotNull(message = "Dashboard status cant be null")
    @ColumnDefault("DashboardStatus.DEACTIVATED")
    private DashboardStatus status;

}
