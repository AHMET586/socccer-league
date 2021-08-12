package com.example.socccer_league.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.socccer_league.Model.Teams;

import java.util.List;

@Dao
public interface TeamsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Teams> teamsList);

    @Query("SELECT * FROM teams")
    LiveData<List<Teams>> getAllTeams();

    @Query("DELETE FROM teams")
    void deleteAll();
}
