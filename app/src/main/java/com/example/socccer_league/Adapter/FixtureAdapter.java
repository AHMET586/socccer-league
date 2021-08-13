package com.example.socccer_league.Adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    private  FixtureRowAdapter fixtureRowAdapter;


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
        List<String> roundTeams = new LinkedList<String>();
        for (Teams teamsName : teamslist) {
            teams.add(teamsName.getName());
        }
        List<List<Fixture<String>>> rounds = fixtureGenerator.getFixtures(teams, true);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.week.setText(String.valueOf(position+1)+". Week");
        for (int i = 0+position; i < rounds.size(); i++) {
            List<Fixture<String>> round = rounds.get(i);
            for (Fixture<String> fixture : round) {
                roundTeams.add(fixture.getHomeTeam());
                roundTeams.add(fixture.getAwayTeam());
            }
            fixtureRowAdapter=new FixtureRowAdapter(context.getApplicationContext(), roundTeams,(roundTeams.size()/2));
            holder.recyclerView.setAdapter(fixtureRowAdapter);
            break;
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
        public TextView week;
        public RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView= itemView.findViewById(R.id.recyclerview_fixture);
            week = itemView.findViewById(R.id.week);
        }
    }
}