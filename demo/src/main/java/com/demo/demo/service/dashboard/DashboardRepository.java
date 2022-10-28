package com.demo.demo.service.dashboard;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardVO, Long> {

    public List<DashboardVO> findByTitle(String title);

    public List<DashboardVO> findByName(String name);

    public List<DashboardVO> findAll();
    
}
