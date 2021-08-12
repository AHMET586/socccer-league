package com.example.socccer_league.Adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.socccer_league.Model.Fixture;
import com.example.socccer_league.Model.FixtureGenerator;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.R;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;
    private List<Teams> teamslist;
    private Context context;

    public FixtureAdapter(Context context, List<Teams> teamslist, ViewPager2 viewPager2) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.viewPager2 = viewPager2;
        this.teamslist = teamslist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fixture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FixtureGenerator<String> fixtureGenerator = new FixtureGenerator();
        List<String> teams = new LinkedList<String>();
        List<String> fixtureTeams = new LinkedList<String>();
        for (Teams teamsName : teamslist) {
            teams.add(teamsName.getName());
        }
        List<List<Fixture<String>>> rounds = fixtureGenerator.getFixtures(teams, true);
        for (int i = 0+position; i < rounds.size(); i++) {
            List<Fixture<String>> round = rounds.get(i);
            for (Fixture<String> fixture : round) {
                fixtureTeams.add(fixture.getHomeTeam());
                fixtureTeams.add(fixture.getAwayTeam());
            }
            holder.week.setText((position+1)+". Week");
            holder.team1.setText(fixtureTeams.get(0));
            holder.team2.setText(fixtureTeams.get(1));
            holder.team3.setText(fixtureTeams.get(2));
            holder.team4.setText(fixtureTeams.get(3));
            holder.team5.setText(fixtureTeams.get(4));
            holder.team6.setText(fixtureTeams.get(5));
            holder.team7.setText(fixtureTeams.get(6));
            holder.team8.setText(fixtureTeams.get(7));
            holder.team9.setText(fixtureTeams.get(8));
            holder.team10.setText(fixtureTeams.get(9));
            holder.team11.setText(fixtureTeams.get(10));
            holder.team12.setText(fixtureTeams.get(11));
        }
    }

    @Override
    public int getItemCount() {
        return 2 * (teamslist.size() - 1);
    }

    public void getAllTeams(List<Teams> teamslist) {
        this.teamslist = teamslist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView week, team1, team2, team3, team4,
                team5, team6, team7, team8,
                team9, team10, team11, team12;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            week = itemView.findViewById(R.id.week);
            team1 = itemView.findViewById(R.id.team1);
            team2 = itemView.findViewById(R.id.team2);
            team3 = itemView.findViewById(R.id.team3);
            team4 = itemView.findViewById(R.id.team4);
            team5 = itemView.findViewById(R.id.team5);
            team6 = itemView.findViewById(R.id.team6);
            team7 = itemView.findViewById(R.id.team7);
            team8 = itemView.findViewById(R.id.team8);
            team9 = itemView.findViewById(R.id.team9);
            team10 = itemView.findViewById(R.id.team10);
            team11 = itemView.findViewById(R.id.team11);
            team12 = itemView.findViewById(R.id.team12);

        }
    }
}