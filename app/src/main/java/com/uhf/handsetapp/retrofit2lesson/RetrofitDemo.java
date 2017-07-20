package com.uhf.handsetapp.retrofit2lesson;

import android.util.Log;

import com.uhf.handsetapp.utils.AssistUtils;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/20 15:04
 * Good Luck
 */

public class RetrofitDemo {
    public void prepareRequest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        GitHub gitHub = retrofit.create(GitHub.class);
        Call<List<Contributor>> call = gitHub.contributors("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                Log.d(AssistUtils.TAG, "response" + response.body().toString());

            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {

            }
        });

    }


}
