package com.debuggers.factory;

import com.debuggers.domain.ProfileImage;

public class ProfileImageFactory {
    public static ProfileImage createProfileImage(Long id, String imageUrl){
        if(id == null || imageUrl == null || imageUrl.isEmpty()){
            return null;
        }

        return new ProfileImage.Builder()
                .setId(id)
                .setImageUrl(imageUrl)
                .build();

    }
}
