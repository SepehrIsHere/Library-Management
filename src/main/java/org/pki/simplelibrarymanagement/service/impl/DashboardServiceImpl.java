package org.pki.simplelibrarymanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.dto.DashboardDTO;
import org.pki.simplelibrarymanagement.entities.Dashboard;
import org.pki.simplelibrarymanagement.exception.DashboardNotFoundException;
import org.pki.simplelibrarymanagement.exception.DashboardOperationException;
import org.pki.simplelibrarymanagement.repository.DashboardRepository;
import org.pki.simplelibrarymanagement.service.DashboardService;
import org.pki.simplelibrarymanagement.util.MapperUtil;
import org.pki.simplelibrarymanagement.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final DashboardRepository dashboardRepository;
    private final MapperUtil mapper;
    private final ValidationUtil validationUtil;

    @Override
    public DashboardDTO save(Dashboard dashboard) {
        try {
            if (!validationUtil.objectHasViolation(dashboard)) {
                validationUtil.throwViolations(dashboard);
            }
            return mapper.convertToDto(dashboardRepository.save(dashboard));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public DashboardDTO update(Dashboard dashboard) {
        try {
            return mapper.convertToDto(dashboardRepository.save(dashboard));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Dashboard dashboard) {
        dashboardRepository.delete(dashboard);
    }

    @Override
    public void deleteById(long id) {
        dashboardRepository.deleteById(id);
    }

    @Override
    public Dashboard findByDashBoardId(Long dashboardId) {
        try {
            return dashboardRepository.findById(dashboardId).orElseThrow(() -> new DashboardNotFoundException("Dashboard not found with id " + dashboardId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public Dashboard findByDashboardName(String dashboardName) {
        try {
            return dashboardRepository.findByDashboardName(dashboardName).orElseThrow(() -> new DashboardNotFoundException("Dashboard not found with name " + dashboardName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public Dashboard findByUserId(Long userId) {
        try {
            return dashboardRepository.findByUser(userId).orElseThrow(() -> new DashboardNotFoundException("Dashboard not found with id " + userId));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public List<Dashboard> findAll() {
        try {
            return dashboardRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<List<Dashboard>> findActiveDashboards() {
        try {
            return Optional.ofNullable(dashboardRepository.findActiveDashboards().orElseThrow(() -> new DashboardNotFoundException("active dashboards not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<List<Dashboard>> findDeactivatedDashboards() {
        try {
            return Optional.ofNullable(dashboardRepository.findDeactivatedDashboards().orElseThrow(() -> new DashboardNotFoundException("deactive dashboards not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }

    @Override
    public Optional<List<Dashboard>> findSuspendedDashboards() {
        try {
            return Optional.ofNullable(dashboardRepository.findSuspendedDashboards().orElseThrow(() -> new DashboardNotFoundException("suspended dashboards not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DashboardOperationException(e.getMessage());
        }
    }
}
