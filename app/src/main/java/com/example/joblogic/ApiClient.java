package com.example.joblogic;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String base_url = "https://my-json-server.typicode.com/";
    private static Retrofit retrofit;

    public static Retrofit getClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}