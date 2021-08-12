package com.example.socccer_league.Network;

import com.example.socccer_league.Model.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("teams.json")
    Call<List<Teams>> getAllTeams();
}
