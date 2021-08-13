package com.example.socccer_league.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socccer_league.Adapter.FixtureRowAdapter;

public class FixtureRowFragment extends Fragment {
    private FixtureRowAdapter fixtureRowAdapter;

    public FixtureRowFragment(FixtureRowAdapter fixtureRowAdapter) {
    this.fixtureRowAdapter=fixtureRowAdapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(fixtureRowAdapter);
        return rv;
    }
}
