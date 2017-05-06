package com.cet.thabjeel.traveller.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cet.thabjeel.traveller.R;
import com.cet.thabjeel.traveller.network.ApiClient;
import com.cet.thabjeel.traveller.network.RestApiInterface;
import com.cet.thabjeel.traveller.network.model.NotificationModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by droidcafe on 5/6/2017
 */

public class Global {

    private static final String TAG = Global.class.getSimpleName();
    public static final String HOST_URL = "http://192.168.42.242";
    public static final String NODE_PORT = "3000";
    public static final String BASE_URL = HOST_URL + ":" + NODE_PORT;


    public static void sendMessage(String id, String message, Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("voyage_pref", 0);

        String from_id = sharedPreferences.getString("_id", "");
        NotificationModel notificationModel = new NotificationModel(message, id, from_id);

        RestApiInterface restApiInterface = ApiClient.getRestApiClient();
        progressDialog.showProgressDialog(R.string.sending,false);
        Call<NotificationModel> notificationModelCall = restApiInterface.sendMessage(notificationModel);

        notificationModelCall.enqueue(new Callback<NotificationModel>() {
            @Override
            public void onResponse(Call<NotificationModel> call, Response<NotificationModel> response) {
                progressDialog.disMissProgressDialog();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: success");
                } else {
                    Log.e(TAG, "onResponse: failed call " + response.message());
                }
            }


            @Override
            public void onFailure(Call<NotificationModel> call, Throwable t) {
                progressDialog.disMissProgressDialog();
                Log.e(TAG, "onFailure: failed" + t.getMessage());
            }
        });
        return;
    }
}
