package org.pki.simplelibrarymanagement.service;

import org.pki.simplelibrarymanagement.dto.DashboardDTO;
import org.pki.simplelibrarymanagement.entities.Dashboard;

import java.util.List;
import java.util.Optional;

public interface DashboardService {
    DashboardDTO save(Dashboard dashboard);

    DashboardDTO update(Dashboard dashboard);

    void delete(Dashboard dashboard);

    void deleteById(long id);

    Dashboard findByDashBoardId(Long dashboardId);

    Dashboard findByDashboardName(String dashboardName);

    Dashboard findByUserId(Long userId);

    List<Dashboard> findAll();

    Optional<List<Dashboard>> findActiveDashboards();

    Optional<List<Dashboard>> findDeactivatedDashboards();

    Optional<List<Dashboard>> findSuspendedDashboards();
}
