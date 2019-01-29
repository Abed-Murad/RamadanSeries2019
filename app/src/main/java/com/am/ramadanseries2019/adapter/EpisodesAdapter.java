package com.am.ramadanseries2019.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.am.ramadanseries2019.databinding.ItemEpisodeBinding;
import com.am.ramadanseries2019.model.Episode;

import java.util.ArrayList;
import java.util.List;

public class EpisodesAdapter extends RecyclerView.Adapter <EpisodesAdapter.ViewHolder >{

    private List<Episode> mEpisodeList;
    private LayoutInflater mInflater;
    private OnEpisodeClickListener mListener;

    public EpisodesAdapter(Context context, OnEpisodeClickListener onEpisodeClickListener) {
        this.mListener = onEpisodeClickListener;
        this.mEpisodeList = new ArrayList<>();
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEpisodeBinding binding = ItemEpisodeBinding.inflate(mInflater, parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.bind(getItem(i));
    }

    private Episode getItem(int position) {
        return mEpisodeList.get(position);
    }

    @Override
    public int getItemCount() {
        return mEpisodeList.size() == 0 ? 20 : mEpisodeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemEpisodeBinding mLayout;

        public ViewHolder(@NonNull ItemEpisodeBinding binding) {
            super(binding.getRoot());
            mLayout = binding;
            binding.getRoot().setOnClickListener(v -> mListener.onItemClick(v , 3 , null));//TODO:Fix This
        }

        private void bind(Episode episode) {
            mLayout.episodeTitleTextView.setText(getAdapterPosition() + " اسم الحلقة ");
        }
    }


    private void clear() {
        mEpisodeList.clear();
    }

    public void addAll(List<Episode> episodeList) {
        clear();
        for (Episode episode : episodeList) {
            add(episode);
        }
        notifyDataSetChanged();
    }

    public void add(Episode episode) {
        mEpisodeList.add(episode);
    }


    public interface OnEpisodeClickListener {
        void onItemClick(View view, int position, Episode model);
    }
}
