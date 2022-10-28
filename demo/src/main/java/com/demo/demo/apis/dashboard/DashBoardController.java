package com.demo.demo.apis.dashboard;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.service.dashboard.DashboardService;
import com.demo.demo.service.dashboard.DashboardVO;

@RestController
public class DashBoardController {

    @Autowired
    DashboardService dashboardService;
    
    @RequestMapping("apis/dashboard/list")
    public List<DashboardVO> dashboardList(
        HttpSession session
    ) {

        return dashboardService.findAll();
    }

    @RequestMapping("apis/dashboard/findbytitle")
    public List<DashboardVO> findDashBoardByTitle(
        DashboardVO dashboardVO,
        @RequestParam String title
    ) {
        List<DashboardVO> dashboard = dashboardService.findByTitle(title);
        return dashboard;
    }

    @RequestMapping("apis/dashboard/insert")
    public String dashboardInsert(
        @RequestBody DashboardVO dashboardVO
    ){

        System.out.println(dashboardVO);
      
        dashboardService.insertDashBoard(dashboardVO);

        return "등록 성공";
    }
}
