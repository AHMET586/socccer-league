package com.example.socccer_league;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.socccer_league.Adapter.FixtureAdapter;
import com.example.socccer_league.Adapter.FixtureRowAdapter;
import com.example.socccer_league.Adapter.TeamsAdapter;
import com.example.socccer_league.Model.Fixture;
import com.example.socccer_league.Model.FixtureGenerator;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.Network.Retrofit;
import com.example.socccer_league.Repository.TeamsRepository;
import com.example.socccer_league.Viewmodel.TeamsViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FixtureActivity extends AppCompatActivity {

    private TeamsViewModel teamsViewModel;
    private List<Teams> teamsList;
    private TeamsRepository TeamsRepository;
    private FixtureAdapter fixtureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        TeamsRepository=new TeamsRepository(getApplication());
        teamsList=new ArrayList<>();
        ViewPager2 viewPager2 = findViewById(R.id.item_fixture);
        fixtureAdapter=new FixtureAdapter(this,teamsList, viewPager2);
        teamsViewModel=new ViewModelProvider(this).get(TeamsViewModel.class);
        TeamsRepository.networkRequest();
        teamsViewModel.getGetAllTeams().observe(this, new Observer<List<Teams>>() {
            @Override
            public void onChanged(List<Teams> teamsList) {
                viewPager2.setAdapter(fixtureAdapter);
                fixtureAdapter.getAllTeams(teamsList);

                Log.d("main", "onChanged: "+teamsList);
            }
        });
    }

}


