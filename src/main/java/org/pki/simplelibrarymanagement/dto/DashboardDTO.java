package org.pki.simplelibrarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDTO {
    private Long id;
    private String name;
    private Long userId;
}
