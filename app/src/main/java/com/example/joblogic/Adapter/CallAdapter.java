package com.example.joblogic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.joblogic.Model.CallModel;
import com.example.joblogic.R;

public class CallAdapter extends RecyclerView.Adapter <CallAdapter.ViewHolder>{

    private Context context;
    private List<CallModel> callList;

    public CallAdapter(Context context, List<CallModel> callModel) {
        this.context = context;
        this.callList = callModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CallModel item = callList.get(position);

        holder.call_id.setText(item.getId());
        holder.call_name.setText(item.getTitle());
        holder.call_number.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return callList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView call_id;
        public TextView call_name;
        public TextView call_number;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            call_id = (TextView) itemView.findViewById(R.id.call_idtext);
            call_name = (TextView) itemView.findViewById(R.id.call_nametext);
            call_number = (TextView) itemView.findViewById(R.id.call_numbertext);

        }
    }
}