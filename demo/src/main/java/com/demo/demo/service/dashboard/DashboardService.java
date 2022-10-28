package com.demo.demo.service.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;
    
    public List<DashboardVO> findAll(){

        return dashboardRepository.findAll();
    }

    public List<DashboardVO> findByTitle(String title) {
        List<DashboardVO> dashboard = dashboardRepository.findByTitle(title);
    
        return dashboard;
    }

    public void insertDashBoard(DashboardVO dashboardVO) {
        dashboardRepository.save(dashboardVO);
    }
}
