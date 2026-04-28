/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JREscert
 */
@Entity
@Table(name = "University_courses")

public class UniversityCourses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name ="university_id", nullable = false)
    private University university;
    
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
    @Column(name = "min_aps_override")
    private Integer minApsOverride;

    public UniversityCourses() {
    }

    public UniversityCourses(University university, Course course, String facultyName, Integer minApsOverride) {
        this.university = university;
        this.course = course;
        this.facultyName = facultyName;
        this.minApsOverride = minApsOverride;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getMinApsOverride() {
        return minApsOverride;
    }

    public void setMinApsOverride(Integer minApsOverride) {
        this.minApsOverride = minApsOverride;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniversityCourses)) {
            return false;
        }
        UniversityCourses other = (UniversityCourses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apexcoders.entities.UniversityCourses[ id=" + id + " ]";
    }
    
}
