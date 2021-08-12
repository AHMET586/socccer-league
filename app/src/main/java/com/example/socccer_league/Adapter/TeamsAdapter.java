package com.example.socccer_league.Adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.socccer_league.Model.Fixture;
import com.example.socccer_league.Model.FixtureGenerator;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.R;

import java.util.LinkedList;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.teamsViewHolder>  {

    private Context context;
    private List<Teams> teamslist;

    public TeamsAdapter(Context context, List<Teams> teamslist, View.OnClickListener listener) {
        this.context = context;
        this.teamslist = teamslist;
    }

    @NonNull
    @Override
    public teamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new teamsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull teamsViewHolder holder, int position) {
        Teams teams = teamslist.get(position);
        holder.name.setText("Name: " + teams.getName());
        holder.shortName.setText("Short Name: " + teams.getShortCode());
        holder.departmentName.setText("Department: " + teams.getDepartmentName());
        holder.founded.setText("Department: " + teams.getFounded());

        Glide.with(context)
                .load(teams.getLogo())
                .into(holder.image);

    }


    public void getAllTeams(List<Teams> teamslist) {
        this.teamslist = teamslist;
    }

    @Override
    public int getItemCount() {
        return teamslist.size();
    }




    public static class teamsViewHolder extends RecyclerView.ViewHolder {
        public TextView departmentName, name, shortName, founded;
        public ImageView image;
        public Button btnFixture;

        public teamsViewHolder(@NonNull View itemView) {
            super(itemView);
            departmentName = itemView.findViewById(R.id.department_name);
            name = itemView.findViewById(R.id.name);
            shortName = itemView.findViewById(R.id.short_name);
            founded = itemView.findViewById(R.id.founded);
            image = itemView.findViewById(R.id.image);
            btnFixture = itemView.findViewById(R.id.btn_fixture);
        }
    }
}
