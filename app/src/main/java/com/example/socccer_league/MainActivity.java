package com.example.socccer_league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.socccer_league.Adapter.TeamsAdapter;
import com.example.socccer_league.Database.TeamsDatabase;
import com.example.socccer_league.Model.Fixture;
import com.example.socccer_league.Model.FixtureGenerator;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.Network.Retrofit;
import com.example.socccer_league.Repository.TeamsRepository;
import com.example.socccer_league.Viewmodel.TeamsViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private TeamsViewModel teamsViewModel;
    private Button btnFixture;
    private RecyclerView recyclerView;
    private List<Teams> teamsList;
    private TeamsRepository TeamsRepository;
    private TeamsAdapter teamsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        TeamsRepository=new TeamsRepository(getApplication());
        teamsList=new ArrayList<>();
        teamsAdapter=new TeamsAdapter(this,teamsList, this);
        btnFixture = (Button) findViewById(R.id.btn_fixture);
        btnFixture.setOnClickListener(this);
        teamsViewModel=new ViewModelProvider(this).get(TeamsViewModel.class);
        TeamsRepository.networkRequest();
        teamsViewModel.getGetAllTeams().observe(this, new Observer<List<Teams>>() {
            @Override
            public void onChanged(List<Teams> teamsList) {
                recyclerView.setAdapter(teamsAdapter);
                teamsAdapter.getAllTeams(teamsList);

                Log.d("main", "onChanged: "+teamsList);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnFixture) {
            Intent newIntent = new Intent(MainActivity.this,FixtureActivity.class);
            startActivity(newIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
