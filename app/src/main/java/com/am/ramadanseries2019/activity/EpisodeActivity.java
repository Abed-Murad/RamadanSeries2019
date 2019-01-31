package com.am.ramadanseries2019.activity;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.Toast;

import com.am.ramadanseries2019.R;
import com.am.ramadanseries2019.adapter.EpisodesAdapter;
import com.am.ramadanseries2019.databinding.ActivityEpisodeBinding;
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
