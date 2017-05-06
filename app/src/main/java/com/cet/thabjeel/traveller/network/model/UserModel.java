package com.cet.thabjeel.traveller.network.model;

import com.facebook.Profile;

/**
 * Created by droidcafe on 5/6/2017
 */

public class UserModel {

    public String firstName, lastName, picUrl, id ,_id,fcm;
    public int code;

    public UserModel() {

    }

    public UserModel(Profile profile) {
        firstName = profile.getFirstName();
        lastName = profile.getLastName();
        picUrl = String.valueOf(profile.getProfilePictureUri(100, 100));
        id = profile.getId();
    }


    public void setFCMToken(String token) {
        fcm = token;
    }
}
