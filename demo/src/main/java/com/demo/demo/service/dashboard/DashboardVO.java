package com.demo.demo.service.dashboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity( name = "dashboard")
public class DashboardVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dashboard_id;

    @Column
    private String title;

    @Column
    private String name;

    public String getTitle() {
        return this.title;
    } 

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    } 

    @Builder
    public DashboardVO(String title, String name) {
        this.title = title;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DashboardVO [_id=" + dashboard_id 
        + ", title=" + title
        + ", name=" + name
        + "]";
    }
}
