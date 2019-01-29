package com.am.ramadanseries2019.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.am.ramadanseries2019.R;
import com.am.ramadanseries2019.adapter.EpisodesAdapter;
import com.am.ramadanseries2019.adapter.SeriesAdapter;
import com.am.ramadanseries2019.databinding.ActivitySeriesBinding;
import com.am.ramadanseries2019.databinding.ContentSeriesBinding;

public class SeriesActivity extends AppCompatActivity {
    private ActivitySeriesBinding mLayout;
    private ContentSeriesBinding mContentLayout;
    private EpisodesAdapter mEpisodesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = DataBindingUtil.setContentView(this, R.layout.activity_series);
        mContentLayout = mLayout.contentLayout;
        setSupportActionBar(mLayout.toolbar);
        setupRecyclerView();
    }


    private void setupRecyclerView() {
        mContentLayout.episodesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mEpisodesAdapter = new EpisodesAdapter(this, (view, position, model) -> {
            Toast.makeText(SeriesActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SeriesActivity.this, EpisodeActivity.class));
        });
        mContentLayout.episodesRecyclerView.setAdapter(mEpisodesAdapter);
    }
}
