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

    //Bu metodda inflate sınıfı kullanılarak, item_viewpager xml'i tanımlandı
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_fixture, parent, false);
        return new ViewHolder(view);
    }

    //Bu metodda layoutdaki arayüz elemanlarına, yazı ve renk değerler atandı
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FixtureGenerator<String> fixtureGenerator = new FixtureGenerator();
        List<String> teams = new LinkedList<String>();
        for (Teams teamsName : teamslist) {
            teams.add(teamsName.getName());
        }
        List<List<Fixture<String>>> rounds = fixtureGenerator.getFixtures(teams, true);
        for (int i = 0; i < rounds.size(); i++) {
            List<Fixture<String>> round = rounds.get(i);
            for (Fixture<String> fixture : round) {
                holder.shortName.setText(fixture.getHomeTeam());
                holder.shortName1.setText(fixture.getAwayTeam());
            }
        }

        /*
        holder.name.setText("Name: " + teams.getName());
        holder.shortName.setText("Short Name: " + teams.getShortCode());
        holder.departmentName.setText("Department: " + teams.getDepartmentName());
        holder.founded.setText("Department: " + teams.getFounded());

        Glide.with(context)
                .load(teams.getLogo())
                .into(holder.image);

         */
    }

    @Override
    public int getItemCount() {
        return 2*(teamslist.size()-1);
    }

    public void getAllTeams(List<Teams> teamslist) {
        this.teamslist = teamslist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView shortName1, name, shortName, founded;
        public ImageView image;
        public Button btnFixture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shortName1 = itemView.findViewById(R.id.short_name1);
            name = itemView.findViewById(R.id.name);
            shortName = itemView.findViewById(R.id.short_name);
            founded = itemView.findViewById(R.id.founded);
            image = itemView.findViewById(R.id.image);
            btnFixture = itemView.findViewById(R.id.btn_fixture);
        }
    }
}