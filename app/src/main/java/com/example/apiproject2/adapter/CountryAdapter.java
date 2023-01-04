package com.example.apiproject2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.apiproject2.R;
import com.example.apiproject2.model.Countries;

import java.text.DecimalFormat;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    Context context;
    List<Countries> data;

    public CountryAdapter(Context context, List<Countries> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.item_country,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DecimalFormat decimalFormat=new DecimalFormat("###,###");
        String NewCon=data.get(position).getNewConfirmed();
        holder.NewConfirmed.setText(decimalFormat.format(Integer.valueOf(NewCon)));

        String NewConTo=data.get(position).getTotalConfirmed();
        holder.TotalConfirmed.setText(decimalFormat.format(Integer.valueOf(NewConTo)));

        String NewDeth=data.get(position).getNewDeaths();
        holder.NewDeaths.setText(decimalFormat.format(Integer.valueOf(NewDeth)));

        String NewDethT=data.get(position).getTotalDeaths();
        holder.TotalDeaths.setText(decimalFormat.format(Integer.valueOf(NewDethT)));

        String NewRec=data.get(position).getNewRecovered();
        holder.NewRecovered.setText(decimalFormat.format(Integer.valueOf(NewRec)));

        String NewRecT=data.get(position).getTotalRecovered();
        holder.TotalRecovered.setText(decimalFormat.format(Integer.valueOf(NewRecT)));

        holder.name.setText(data.get(position).getCountry());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView name, NewConfirmed,TotalConfirmed,NewDeaths,TotalDeaths,NewRecovered,TotalRecovered;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NewConfirmed=itemView.findViewById(R.id.NewConfirmed);
            TotalConfirmed=itemView.findViewById(R.id.TotalConfirmed);
            NewDeaths=itemView.findViewById(R.id.NewDeaths);
            TotalDeaths=itemView.findViewById(R.id.TotalDeaths);
            NewRecovered=itemView.findViewById(R.id.NewRecovered);
            TotalRecovered=itemView.findViewById(R.id.TotalRecovered);
            name=itemView.findViewById(R.id.name);
        }
    }
}
