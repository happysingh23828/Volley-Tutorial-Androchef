package com.androchef.volley.normalvolleycall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androchef.volley.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomRecyclerViewHolder> {

    private List<Worldpopulation> listOfPopulation;
    private Context context;

    public CustomRecyclerAdapter(List<Worldpopulation> listOfPopulation, Context context) {
            this.listOfPopulation = listOfPopulation;
            this.context = context;
    }

    @NonNull
    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.single_world_population_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewHolder customRecyclerViewHolder, int i) {
        customRecyclerViewHolder.bind(listOfPopulation.get(i));
    }

    @Override
    public int getItemCount() {
        return listOfPopulation.size();
    }

    class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{

        View view;
        TextView countryName,countryPopulationCount,countryRank;
        ImageView countryFlag;

        CustomRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            countryFlag = view.findViewById(R.id.img_flag);
            countryName = view.findViewById(R.id.txt_country_name);
            countryRank = view.findViewById(R.id.txt_rank);
            countryPopulationCount = view.findViewById(R.id.txt_population);
        }

        void bind(Worldpopulation worldpopulation){
            countryName.setText(worldpopulation.getCountry());
            countryPopulationCount.setText(worldpopulation.getPopulation());
            countryRank.setText(String.valueOf(worldpopulation.getRank()));
            Picasso.get().load(worldpopulation.getFlag()).into(countryFlag);
        }
    }
}
