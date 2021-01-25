package com.example.joblogic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.joblogic.Adapter.SellAdapter;
import com.example.joblogic.DBHandler.DBSellHandler;
import com.example.joblogic.Model.SellModel;

import java.util.ArrayList;
import java.util.List;

public class SellActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<SellModel> listItem;
    private SellAdapter sellAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        recyclerView = (RecyclerView) findViewById(R.id.sellRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        DBSellHandler db = new DBSellHandler(this);

        db.addSellInfo(new SellModel("iPhone X", "150000", "1", "2"));
        db.addSellInfo(new SellModel("TV", "38000", "2", "2"));
        db.addSellInfo(new SellModel("Table", "12000", "1", "2"));


        listItem = new ArrayList<>();
        List<SellModel> sellList = db.getAllSellData();

        for (SellModel c : sellList){
            SellModel itemList = new SellModel
                    (
                    "ID" + c.getId(),
                    "Name: "+c.getName(),
                    "Price: "+ c.getPrice(),
                    "Quantity" + c.getQuantity(),
                    "Type" + c.getType()
                    );
            Log.d("Name",c.getName());
            Log.d("Ne","Dfdf");

            listItem.add(itemList);
        }

        sellAdapter = new SellAdapter(getApplicationContext(),listItem);
        recyclerView.setAdapter(sellAdapter);
    }
}