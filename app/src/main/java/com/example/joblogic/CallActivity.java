package com.example.joblogic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

import android.os.Bundle;
import android.widget.Toast;

import com.example.joblogic.Adapter.CallAdapter;
import com.example.joblogic.Model.CallModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private RecyclerView.Adapter adapter;
    private List<CallModel> call_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);
        Call<List<CallModel>> call = jsonPlaceHolderApi.getCall();

        call.enqueue(new Callback<List<CallModel>>() {
            @Override
            public void onResponse(Call<List<CallModel>> call, Response<List<CallModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(CallActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<CallModel> callitems = response.body();
                call_list = new ArrayList<>();

                for (CallModel item : callitems) {
                    CallModel callModel = new CallModel(
                            "Id: "+item.getId(),
                            "Name: "+item.getTitle(),
                            "Number: "+item.getDesc()
                    );
                    call_list.add(callModel);
                }

                adapter = new CallAdapter(getApplicationContext(), call_list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CallModel>> call, Throwable t) {
                Toast.makeText(CallActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


          }
}