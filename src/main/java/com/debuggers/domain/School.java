package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "school", schema = "prt3debuggers")
public class School {
    @Id
    @Column(name = "school_id", nullable = false)
    private Long id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_address")
    private String schoolAddress;

    public School() {
    }

    private School(Builder builder) {
        this.id = builder.id;
        this.schoolName = builder.schoolName;
        this.schoolAddress = builder.schoolAddress;

    }

    public Long getId() {
        return id;
    }



    public String getSchoolName() {
        return schoolName;
    }



    public String getSchoolAddress() {
        return schoolAddress;
    }





    public static class Builder{
        private Long id;
        private String schoolName;
        private String schoolAddress;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setSchoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }

        public Builder setSchoolAddress(String schoolAddress) {
            this.schoolAddress = schoolAddress;
            return this;
        }

        public Builder copy(School school){
            this.id = school.getId();
            this.schoolName = school.getSchoolName();
            this.schoolAddress = school.getSchoolAddress();
            return this;
        }

        public School build(){
            return new School(this);
        }
    }
}