package com.example.joblogic;

import com.example.joblogic.Model.CallModel;
import com.example.joblogic.Model.BuyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("imkhan334/demo-1/call")
    Call<List<CallModel>> getCall();

    @GET("imkhan334/demo-1/buy")
    Call<List<BuyModel>> getBuy();
}
