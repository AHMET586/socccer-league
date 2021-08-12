package com.example.socccer_league.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.Repository.TeamsRepository;

import java.util.List;

public class TeamsViewModel extends AndroidViewModel {

    private TeamsRepository teamsRepository;
    private LiveData<List<Teams>> getAllTeams;

    public TeamsViewModel(@NonNull Application application) {
        super(application);
        teamsRepository=new TeamsRepository(application);
        getAllTeams=teamsRepository.getAllTeams();
    }

    public void insert(List<Teams> list)
    {
        teamsRepository.insert(list);
    }

    public LiveData<List<Teams>> getGetAllTeams()
    {
        return getAllTeams;
    }



}
