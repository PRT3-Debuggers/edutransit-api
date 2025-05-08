package com.debuggers.service;

import com.debuggers.domain.ProfileImage;

import java.util.List;

public interface ProfileImageService {
    ProfileImage save(ProfileImage profileImage);
    ProfileImage findById(Long id);
    List<ProfileImage> findAll();
    void delete(Long id);
}
