package com.debuggers.service.impl;

import com.debuggers.domain.Parent;
import com.debuggers.domain.ProfileImage;
import com.debuggers.repository.ProfileImageRepository;
import com.debuggers.service.ProfileImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {

    private final ProfileImageRepository profileImageRepository;

    public ProfileImageServiceImpl(ProfileImageRepository profileImageRepository) {
        this.profileImageRepository = profileImageRepository;
    }


    @Override
    public ProfileImage save(ProfileImage profileImage) {
        return profileImageRepository.save(profileImage);
    }

    @Override
    public ProfileImage findById(Long id) {
        return profileImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProfileImage> findAll() {
        return profileImageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        profileImageRepository.deleteById(id);
    }


}
