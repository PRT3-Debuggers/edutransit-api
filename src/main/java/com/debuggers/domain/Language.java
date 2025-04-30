package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language", schema = "prt3debuggers")
public class Language {
    @Id
    @Column(name = "language_id", nullable = false)
    private Long id;

    @Column(name = "language_name", nullable = false, length = 50)
    private String languageName;

    @Column(name = "code", nullable = false, length = 3)
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}