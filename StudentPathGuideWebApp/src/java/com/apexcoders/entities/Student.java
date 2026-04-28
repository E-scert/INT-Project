/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apexcoders.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

/**
 *
 * @author JREscert
 */
@Entity
@Table(name ="Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "username", nullable = false, length= 50)
    private String username;
    
    @Column(name = "grade",nullable = false)
    private Integer grade;
    
    @Column(name = "field_of_interest",nullable = false)
    private String fieldOfInterest;
    
    @Column(name = "APS", nullable = false)
    private Integer aps;
    
    // JPA will create a join table for this map
    @ElementCollection
    @CollectionTable(
        name = "Student_Subject_Marks",
        joinColumns = @JoinColumn(name = "student_id")
    )
    @MapKeyColumn(name = "subject")
    @Column(name = "mark")
    private Map<String, Integer> subjectMarks = new HashMap<>();

    public Student() {
    }

    public Student(String username, Integer grade, String fieldOfInterest, Integer aps) {
        this.username = username;
        this.grade = grade;
        this.fieldOfInterest = fieldOfInterest;
        this.aps = aps;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getFieldOfInterest() {
        return fieldOfInterest;
    }

    public void setFieldOfInterest(String fieldOfInterest) {
        this.fieldOfInterest = fieldOfInterest;
    }

    public Integer getAps() {
        return aps;
    }

    public void setAps(Integer aps) {
        this.aps = aps;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apexcoders.entities.Student[ id=" + id + " ]";
    }
    
}
