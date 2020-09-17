package com.example.ccsm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

   public List<Currencies> mCurrencies ;
    Context mContext;


    public  MyAdapter(List<Currencies>mCurrencies, Context mContext) {
        this.mCurrencies = mCurrencies;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //change the properties of our UI elements


        holder.moneyPair.setText(mCurrencies.get(position).getBase());
        holder.moneyRate.setText((int) mCurrencies.get(position).getRates());
        holder.txtQuote.setText(mCurrencies.get(position).getQuote());
    }

    @Override
    public int getItemCount() {
        return mCurrencies.size();
    }

    public void setCurrencies(List<Currencies> mCurrencies) {
        this.mCurrencies = mCurrencies;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
         private TextView moneyPair;
         private TextView moneyRate;
         private TextView txtQuote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //add other elements in your layout file like this
             moneyPair = itemView.findViewById(R.id.money_pairs);
             moneyRate = itemView.findViewById(R.id.money_rates);
             txtQuote = itemView.findViewById(R.id.qoute);
        }
    }

}
