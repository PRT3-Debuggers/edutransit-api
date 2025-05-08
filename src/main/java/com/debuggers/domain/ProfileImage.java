package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profileimage", schema = "prt3debuggers")
public class ProfileImage {
    @Id
    @Column(name = "image_id", nullable = false)
    private Long id;

    @Column(name = "image_url", nullable = false, length = 2048)
    private String imageUrl;

    public ProfileImage() {
    }

    public ProfileImage(Builder builder) {
        this.id = builder.id;
        this.imageUrl = builder.imageUrl;

    }

    public Long getId() {
        return id;
    }



    public String getImageUrl() {
        return imageUrl;
    }



    public static class Builder {
        private Long id;
        private String imageUrl;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder copy(ProfileImage profileimage) {
            this.id = profileimage.getId();
            this.imageUrl = profileimage.getImageUrl();
            return this;
        }

        public ProfileImage build() {
            return new ProfileImage(this);
        }
    }

}