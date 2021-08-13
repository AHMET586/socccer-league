package com.example.socccer_league.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socccer_league.Model.Fixture;
import com.example.socccer_league.Model.FixtureGenerator;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.R;

import java.util.LinkedList;
import java.util.List;

public class FixtureRowAdapter extends RecyclerView.Adapter<FixtureRowAdapter.ViewHolder>{
    private LayoutInflater mInflater;
    private List<String> roundTeams;
    private Context context;
    private int roundSize;


    public FixtureRowAdapter( Context context,List<String> roundTeams, int roundSize) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.roundTeams=roundTeams;
        this.roundSize=roundSize;
    }

    @Override
    public FixtureRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fixture_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FixtureRowAdapter.ViewHolder holder, int position) {
        holder.team1.setText(roundTeams.get(position));
        holder.team2.setText(roundTeams.get(position+1));
    }


    @Override
    public int getItemCount() {
        return roundSize;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView week, team1, team2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team1 = itemView.findViewById(R.id.team1);
            team2 = itemView.findViewById(R.id.team2);
        }
    }
}
