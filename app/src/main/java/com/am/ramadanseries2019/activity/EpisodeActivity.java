package com.am.ramadanseries2019.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.am.ramadanseries2019.R;
import com.am.ramadanseries2019.adapter.EpisodesAdapter;
import com.am.ramadanseries2019.adapter.SeriesAdapter;
import com.am.ramadanseries2019.databinding.ActivityEpisodeBinding;
import com.am.ramadanseries2019.model.Episode;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;

public class EpisodeActivity extends AppCompatActivity {
    private ActivityEpisodeBinding mLayout;
    private EpisodesAdapter mEpisodesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = DataBindingUtil.setContentView(this, R.layout.activity_episode);
        setupYoutubeView();
        setupRecyclerView();
    }

    private void setupYoutubeView() {
        getLifecycle().addObserver(mLayout.youtubeView);
        mLayout.youtubeView.getPlayerUIController().showFullscreenButton(false);
        mLayout.youtubeView.initialize(
                initializedYouTubePlayer ->
                        initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                            @Override
                            public void onReady() {
                                initializedYouTubePlayer.loadVideo("XEyhoB-hUrE", 0);
                            }
                        }), true);
    }



    private void setupRecyclerView() {
        mLayout.episodesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mEpisodesAdapter = new EpisodesAdapter(this, (view, position, model) -> {
            Toast.makeText(EpisodeActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(EpisodeActivity.this, EpisodeActivity.class));
        });
        mLayout.episodesRecyclerView.setAdapter(mEpisodesAdapter);
    }
}
