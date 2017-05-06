package com.cet.thabjeel.traveller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.cet.thabjeel.traveller.network.ApiClient;
import com.cet.thabjeel.traveller.network.RestApiInterface;
import com.cet.thabjeel.traveller.network.model.UserModel;
import com.cet.thabjeel.traveller.util.Global;
import com.cet.thabjeel.traveller.util.ProgressDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageDemo extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = MessageDemo.class.getSimpleName();
    ProgressDialog progressDialog;
    HashMap<String,UserModel> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        users= new HashMap<>();
        progressDialog = new ProgressDialog(this);

        findViewById(R.id.send).setOnClickListener(this);
      //  loadUsers();
    }

    private void loadUsers() {
        progressDialog.showProgressDialog(R.string.load_users, false);
        RestApiInterface restApiInterface = ApiClient.getRestApiClient();
        Call<List<UserModel>> allUserCall = restApiInterface.getAllUsers();
        allUserCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                progressDialog.disMissProgressDialog();
                if (response.isSuccessful()) {
                    List<UserModel> users = response.body();
                    setUI(users);
                } else {
                    Log.e(TAG, "onResponse: response failed" + response.message());
                }

            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                progressDialog.disMissProgressDialog();
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void setUI(List<UserModel> users) {
        List<String> names = new ArrayList<>(users.size());


        Log.d(TAG, "setUI: size of "+users.size());
         final String selectedUser;
        for (UserModel user : users) {
            Log.d(TAG, "setUI: "+user.firstName);
            names.add(user.firstName);
            this.users.put(user.firstName,user);
        }




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemClick: " + i + " " + users.get(i).lastName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                EditText message = (EditText) findViewById(R.id.message);
                String text = message.getText().toString();
                send(text);
                break;
        }
    }

    private void send(String text) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("voyage_pref", 0);

        String from_id = sharedPreferences.getString("_id", "");
        Global.sendMessage(from_id,text,this);
    }
}
