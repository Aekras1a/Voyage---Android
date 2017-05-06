package com.cet.thabjeel.traveller.network;

import com.cet.thabjeel.traveller.network.model.NotificationModel;
import com.cet.thabjeel.traveller.network.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by droidcafe on 5/6/2017
 */

public interface RestApiInterface {

    @PUT("login/")
    Call<UserModel> saveUser(@Body UserModel userModel);

    @PUT("login/{id}")
    Call<UserModel> updateUser(@Path("id") String id, @Body UserModel userModel);

    @GET("users/")
    Call<List<UserModel>> getAllUsers();

    @PUT("users/notify")
    Call<NotificationModel> sendMessage( @Body NotificationModel notificationModel);

}
