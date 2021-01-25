package com.example.joblogic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joblogic.Model.SellModel;
import com.example.joblogic.R;

import java.util.ArrayList;

public class SellAdapter extends RecyclerView.Adapter <SellAdapter.ViewHolder> {

    private ArrayList<SellModel> sellList =new ArrayList<>();
    private Context context;

    public SellAdapter(Context context, ArrayList<SellModel> sellList) {
        this.context = context;
        this.sellList = sellList;
    }

    public SellAdapter(){};

    @NonNull
    @Override
    public SellAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sell_list, parent, false);
        return new SellAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SellModel item = sellList.get(position);

        holder.sell_id.setText(item.getId());
        holder.sell_name.setText(item.getName());
        holder.sell_price.setText(item.getPrice());
        holder.sell_quantity.setText(item.getQuantity());
        holder.sell_typet.setText(item.getType());
    }

    @Override
    public int getItemCount() {
        return sellList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sell_id;
        public TextView sell_name;
        public TextView sell_price;
        public TextView sell_quantity;
        public TextView sell_typet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sell_id = (TextView) itemView.findViewById(R.id.sell_idtext);
            sell_name = (TextView) itemView.findViewById(R.id.sell_nametext);
            sell_price = (TextView) itemView.findViewById(R.id.sell_pricetext);
            sell_quantity = (TextView) itemView.findViewById(R.id.sell_quantitytext);
            sell_typet = (TextView) itemView.findViewById(R.id.sell_typetext);
        }
    }
}
