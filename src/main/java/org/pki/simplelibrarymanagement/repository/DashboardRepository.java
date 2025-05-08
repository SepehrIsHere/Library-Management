package org.pki.simplelibrarymanagement.repository;

import org.pki.simplelibrarymanagement.entities.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    @Query("SELECT d FROM Dashboard d WHERE d.dashBoardId = :dashBoardId")
    Optional<Dashboard> findByDashboardId(@Param("dashBoardId") String dashBoardId);

    @Query("SELECT d FROM Dashboard d WHERE d.dashboardName = :dashBoardName")
    Optional<Dashboard> findByDashboardName(@Param("dashBoardName") String dashBoardName);

    @Query("SELECT d FROM Dashboard d WHERE d.user.id = :id")
    Optional<Dashboard> findByUser(@Param("id") Long userId);

    @Query("SELECT d FROM Dashboard d WHERE d.status = :Deactivated")
    Optional<List<Dashboard>> findDeactivatedDashboards();

    @Query("SELECT d FROM Dashboard d WHERE d.status = :Suspended")
    Optional<List<Dashboard>> findSuspendedDashboards();

    @Query("SELECT d FROM Dashboard d WHERE d.status = :Active")
    Optional<List<Dashboard>> findActiveDashboards();

}
