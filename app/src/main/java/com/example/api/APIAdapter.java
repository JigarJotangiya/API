package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class APIAdapter extends RecyclerView.Adapter<APIAdapter.ViewHolder> {

    MainActivity mainActivity ;
    List<Entry> datalist;

    public APIAdapter(MainActivity mainActivity, List<Entry> datalist) {

        this.mainActivity = mainActivity;
        this.datalist = datalist;


    }

    @NonNull
    @Override
    public APIAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.listitem,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull APIAdapter.ViewHolder holder, int position) {

        holder.api.setText("API :"+ datalist.get(position).getApi());
        holder.description.setText("Description :"+ datalist.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView api,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            api = itemView.findViewById(R.id.api);
            description = itemView.findViewById(R.id.description);

        }
    }
}
