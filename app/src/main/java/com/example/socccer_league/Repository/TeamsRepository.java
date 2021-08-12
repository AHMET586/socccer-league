package com.example.socccer_league.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.socccer_league.Dao.TeamsDao;
import com.example.socccer_league.Database.TeamsDatabase;
import com.example.socccer_league.MainActivity;
import com.example.socccer_league.Model.Teams;
import com.example.socccer_league.Network.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsRepository {
    private TeamsDatabase database;
    private LiveData<List<Teams>> getAllTeams;

    public TeamsRepository(Application application)
    {
        database=database.getInstance(application);
        getAllTeams=database.teamsDao().getAllTeams();
    }

    public void insert(List<Teams> teamsList){
        new InsertAsynTask(database).execute(teamsList);
    }

    public LiveData<List<Teams>> getAllTeams()
    {
        return getAllTeams;
    }

    static class InsertAsynTask extends AsyncTask<List<Teams>,Void,Void> {
        private TeamsDao teamsDao;
        InsertAsynTask(TeamsDatabase teamsDatabase)
        {
            teamsDao=teamsDatabase.teamsDao();
        }
        @Override
        protected Void doInBackground(List<Teams>... lists) {
            teamsDao.insert(lists[0]);
            return null;
        }
    }

    public void networkRequest() {

        Retrofit retrofit=new Retrofit();
        Call<List<Teams>> call=retrofit.api.getAllTeams();
        call.enqueue(new Callback<List<Teams>>() {
            @Override
            public void onResponse(Call<List<Teams>> call, Response<List<Teams>> response) {
                if(response.isSuccessful())
                {
                    insert(response.body());
                    Log.d("main", "onResponse: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Teams>> call, Throwable t) {
                Log.d("main", "onResponse: "+"something went wrong...");
            }
        });

    }
}
