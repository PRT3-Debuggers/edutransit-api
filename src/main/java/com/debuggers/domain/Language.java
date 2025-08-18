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

    public Language() {
    }

    public Language(Builder builder) {
        this.id = builder.id;
        this.languageName = builder.languageName;
        this.code = builder.code;
    }

    public Long getId() {
        return id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getCode() {
        return code;
    }


    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String languageName;
        private String code;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setLanguageName(String languageName) {
            this.languageName = languageName;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder copy(Language language) {
            this.id = language.getId();
            this.languageName = language.getLanguageName();
            this.code = language.getCode();
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }
}
