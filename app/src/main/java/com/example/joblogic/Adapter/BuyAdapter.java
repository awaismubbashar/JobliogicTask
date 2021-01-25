package com.example.joblogic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joblogic.Model.BuyModel;
import com.example.joblogic.R;

import java.util.List;

public class BuyAdapter extends RecyclerView.Adapter <BuyAdapter.ViewHolder>{

        private Context context;
        private List<BuyModel> buyList;

    public BuyAdapter(Context context, List<BuyModel> buyList) {
            this.context = context;
            this.buyList = buyList;
        }

        @NonNull
        @Override
        public BuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_list ,parent,false);
            return new BuyAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            BuyModel item = buyList.get(position);

            holder.buy_id.setText(item.getId());
            holder.buy_name.setText(item.getName());
            holder.buy_price.setText(item.getPrice());
            holder.buy_quantity.setText(item.getQuantity());
            holder.buy_type.setText(item.getType());
        }

        @Override
        public int getItemCount() {
            return buyList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView buy_id;
            public TextView buy_name;
            public TextView buy_price;
            public TextView buy_quantity;
            public TextView buy_type;
            public ViewHolder(@NonNull View itemView){
                super(itemView);

                buy_id = (TextView) itemView.findViewById(R.id.buy_idtext);
                buy_name = (TextView) itemView.findViewById(R.id.buy_nametext);
                buy_price = (TextView) itemView.findViewById(R.id.buy_pricetext);
                buy_quantity = (TextView) itemView.findViewById(R.id.buy_quatitytext);
                buy_type = (TextView) itemView.findViewById(R.id.buy_typetext);
            }
        }
}
