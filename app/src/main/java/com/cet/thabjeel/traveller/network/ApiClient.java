package com.cet.thabjeel.traveller.network;

import com.cet.thabjeel.traveller.util.Global;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.gsonfire.DateSerializationPolicy;
import io.gsonfire.GsonFireBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by droidcafe on 12/11/2016.
 */

public class ApiClient {

    private static final String TAG = ApiClient.class.getSimpleName();
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("User-Agent", "Lyff-Doctor")
                            .method(original.method(), original.body());
                    return chain.proceed(requestBuilder.build());
                }
            })
            .retryOnConnectionFailure(true)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build();


    private static final GsonFireBuilder gsonFireBuilder = new GsonFireBuilder()
            .dateSerializationPolicy(DateSerializationPolicy.rfc3339);

    private static Retrofit retrofit;


    public static RestApiInterface getRestApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Global.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonFireBuilder.createGson()))
                .client(okHttpClient)
                .build();
        ;

        return retrofit.create(RestApiInterface.class);
    }


}
