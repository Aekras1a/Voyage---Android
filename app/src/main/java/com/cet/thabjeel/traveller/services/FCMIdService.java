package com.cet.thabjeel.traveller.services;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cet.thabjeel.traveller.network.ApiClient;
import com.cet.thabjeel.traveller.network.RestApiInterface;
import com.cet.thabjeel.traveller.network.model.UserModel;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FCMIdService extends FirebaseInstanceIdService {

    public FCMIdService() {
    }

    private static final String TAG = FCMIdService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        saveToken(refreshedToken);

    }

    private void saveToken(String refreshedToken) {
        SharedPreferences sharedPref = this.getSharedPreferences("voyage_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("fcm", refreshedToken);
        editor.apply();

        String _id = sharedPref.getString("_id", "");
        if (_id != null && !_id.equals("")) {
            sentTokenServer(_id, refreshedToken);
        }
    }

    private void sentTokenServer(String _id, String refreshedToken) {
        RestApiInterface restApiInterface = ApiClient.getRestApiClient();
        UserModel userModel = new UserModel();
        userModel.setFCMToken(refreshedToken);

        Call<UserModel> userModelCall = restApiInterface.updateUser(_id, userModel);

        Log.d(TAG, "saveProfile: saving");
        userModelCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    UserModel userModel1 = response.body();
                    Log.d(TAG, "onResponse: Saved successfully ");
                } else {
                    Log.e("la", "Failed to save " + response.errorBody() + "  message is " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("la", "Failed to save onfailure" + t.getMessage());

            }
        });
    }
}