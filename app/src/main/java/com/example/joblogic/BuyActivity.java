package com.example.joblogic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

import android.os.Bundle;
import android.widget.Toast;

import com.example.joblogic.Adapter.BuyAdapter;
import com.example.joblogic.Model.BuyModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<BuyModel> buy_list;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jsonPlaceHolderApi = ApiClient.getClient().create(JsonPlaceHolderApi.class);
        Call<List<BuyModel>> call = jsonPlaceHolderApi.getBuy();

        call.enqueue(new Callback<List<BuyModel>>() {
            @Override
            public void onResponse(Call<List<BuyModel>> call, Response<List<BuyModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(BuyActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<BuyModel> buyitems = response.body();
                buy_list = new ArrayList<>();

                for (BuyModel item : buyitems) {
                    BuyModel buymodel = new BuyModel(
                            "Id: "+item.getId(),
                            "Name: "+item.getName(),
                            "Price: "+item.getPrice(),
                            "Quantity"+item.getQuantity(),
                            "Type"+item.getType()
                    );
                    buy_list.add(buymodel);
                }

                adapter = new BuyAdapter(getApplicationContext(), buy_list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<BuyModel>> call, Throwable t) {
                Toast.makeText(BuyActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}