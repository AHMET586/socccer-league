package com.example.socccer_league.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.socccer_league.R;

import java.util.List;

public class FixtureRowAdapter extends RecyclerView.Adapter<FixtureRowAdapter.ViewHolder>{
    private LayoutInflater mInflater;
    private List<String> roundTeams;
    private List<String> logoTeams;
    private Context context;
    private int roundSize;


    public FixtureRowAdapter( Context context,List<String> roundTeams, int roundSize,List<String>logoTeams) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.roundTeams=roundTeams;
        this.logoTeams=logoTeams;
        this.roundSize=roundSize;
    }

    @Override
    public FixtureRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fixture_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FixtureRowAdapter.ViewHolder holder, int position) {
        holder.teamHome.setText(roundTeams.get(2*position));
        holder.teamAway.setText(roundTeams.get(2*position+1));
        Glide.with(context)
                .load(logoTeams.get(2*position))
                .into(holder.teamHomeLogo);
        Glide.with(context)
                .load(logoTeams.get(2*position+1))
                .into(holder.teamAwayLogo);
    }


    @Override
    public int getItemCount() {
        return roundSize;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView teamHome, teamAway;
        public ImageView teamHomeLogo,teamAwayLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamHome = itemView.findViewById(R.id.teamHome);
            teamAway = itemView.findViewById(R.id.teamAway);
            teamHomeLogo = itemView.findViewById(R.id.teamHomeLogo);
            teamAwayLogo = itemView.findViewById(R.id.teamAwayLogo);
        }
    }
}
