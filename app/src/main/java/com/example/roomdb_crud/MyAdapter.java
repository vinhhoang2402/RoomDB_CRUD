package com.example.roomdb_crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<MyDataList> myDataLists;
    Context context;

    public MyAdapter(List<MyDataList> myDataLists, Context context) {
        this.myDataLists = myDataLists;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.txt_name.setText(myDataLists.get(position).getName());
        holder.txt_email.setText(myDataLists.get(position).getEmail());
        holder.txt_city.setText(myDataLists.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return myDataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_name,txt_email,txt_city;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_email=itemView.findViewById(R.id.txt_email);
            txt_city=itemView.findViewById(R.id.txt_city);
        }
    }
}
