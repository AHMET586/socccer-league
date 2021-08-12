package com.example.socccer_league.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.socccer_league.Dao.TeamsDao;
import com.example.socccer_league.Model.Teams;

@Database(entities = {Teams.class}, version = 2)
public abstract class TeamsDatabase extends RoomDatabase {

    private static final String DATABASE_NAME="TeamsDatabase";

    public abstract TeamsDao teamsDao();

    private static volatile TeamsDatabase INSTANCE;

    public static TeamsDatabase getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (TeamsDatabase.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context,TeamsDatabase.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static RoomDatabase.Callback callback=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };
    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private TeamsDao teamsDao;
        PopulateAsynTask(TeamsDatabase TeamsDatabase)
        {
            teamsDao=TeamsDatabase.teamsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            teamsDao.deleteAll();
            return null;
        }
    }
}
