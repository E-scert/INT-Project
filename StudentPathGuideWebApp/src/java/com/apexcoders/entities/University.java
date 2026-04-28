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
@Table(name="University")
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="university_name",nullable = false)
    private String universityName;
    
    @Column(name = "university_abbreviation",nullable = false)
    private String universityAbbreviation;
    
    @Column( name="university_province",nullable = false)
    private String universityProvince;
    
    @Column(name="university_website",nullable = false)
    private String universityWebsite;
    
    @OneToMany(mappedBy = "university")
    private List<UniversityCourses> universityCourses;

    public University() {
    }

    public University(String universityName, String universityAbbreviation, String universityProvince, String universityWebsite, List<UniversityCourses> universityCourses) {
        this.universityName = universityName;
        this.universityAbbreviation = universityAbbreviation;
        this.universityProvince = universityProvince;
        this.universityWebsite = universityWebsite;
        this.universityCourses = universityCourses;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityAbbreviation() {
        return universityAbbreviation;
    }

    public void setUniversityAbbreviation(String universityAbbreviation) {
        this.universityAbbreviation = universityAbbreviation;
    }

    public String getUniversityProvince() {
        return universityProvince;
    }

    public void setUniversityProvince(String universityProvince) {
        this.universityProvince = universityProvince;
    }

    public String getUniversityWebsite() {
        return universityWebsite;
    }

    public void setUniversityWebsite(String universityWebsite) {
        this.universityWebsite = universityWebsite;
    }

    public List<UniversityCourses> getUniversityCourses() {
        return universityCourses;
    }

    public void setUniversityCourses(List<UniversityCourses> universityCourses) {
        this.universityCourses = universityCourses;
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
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apexcoders.entities.University[ id=" + id + " ]";
    }
    
}
