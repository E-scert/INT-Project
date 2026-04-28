/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JREscert
 */
@Entity
@Table(name="Course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     @Column(name="course_name",nullable = false)
    private String courseName;
     @Column(name="course_field",nullable = false)
    private String courseField;
     @Column(name="course_min_aps",nullable = false)
    private Integer courseMinAps;
    
    @Column(name="course_description",nullable = false)
    private String courseDescription;
    
    @Column(name="course_required_subjects",nullable = false)
    private String courseRequiredSubjects;
    
    @OneToMany(mappedBy = "course")
    private List<UniversityCourses> univeristyCourses;

    public Course() {
    }

    public Course(String courseName, String courseField, Integer courseMinAps, String courseDescription, String courseRequiredSubjects, List<UniversityCourses> univeristyCourses) {
        this.courseName = courseName;
        this.courseField = courseField;
        this.courseMinAps = courseMinAps;
        this.courseDescription = courseDescription;
        this.courseRequiredSubjects = courseRequiredSubjects;
        this.univeristyCourses = univeristyCourses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseField() {
        return courseField;
    }

    public void setCourseField(String courseField) {
        this.courseField = courseField;
    }

    public Integer getCourseMinAps() {
        return courseMinAps;
    }

    public void setCourseMinAps(Integer courseMinAps) {
        this.courseMinAps = courseMinAps;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseRequiredSubjects() {
        return courseRequiredSubjects;
    }

    public void setCourseRequiredSubjects(String courseRequiredSubjects) {
        this.courseRequiredSubjects = courseRequiredSubjects;
    }

    public List<UniversityCourses> getUniveristyCourses() {
        return univeristyCourses;
    }

    public void setUniveristyCourses(List<UniversityCourses> univeristyCourses) {
        this.univeristyCourses = univeristyCourses;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apexcoders.entities.Course[ id=" + id + " ]";
    }
    
}
