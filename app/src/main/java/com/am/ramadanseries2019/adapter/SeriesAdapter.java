package com.am.ramadanseries2019.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.am.ramadanseries2019.databinding.ItemSeriesBinding;

import com.am.ramadanseries2019.model.Series;

import java.util.ArrayList;
import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {
    private List<Series> mSeriesList;
    private LayoutInflater mInflater;
    private OnCategoryClickListener mListener;

    public SeriesAdapter(Context context, OnCategoryClickListener onCategoryClickListener) {
        this.mListener = onCategoryClickListener;
        this.mSeriesList = new ArrayList<>();
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSeriesBinding binding = ItemSeriesBinding.inflate(mInflater, parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.bind(getItem(i));
    }

    private Series getItem(int position) {
        return mSeriesList.get(position);
    }

    @Override
    public int getItemCount() {
        return mSeriesList.size() == 0 ? 20 : mSeriesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemSeriesBinding mLayout;

        public ViewHolder(@NonNull ItemSeriesBinding binding) {
            super(binding.getRoot());
            mLayout = binding;
            binding.getRoot().setOnClickListener(v -> mListener.onItemClick(v , 3 , null));//TODO:Fix This
        }

        private void bind(Series series) {
            mLayout.seriesTitle.setText(getAdapterPosition() + " اسم المسلسل ");
        }
    }


    private void clear() {
        mSeriesList.clear();
    }

    public void addAll(List<Series> seriesList) {
        clear();
        for (Series series : seriesList) {
            add(series);
        }
        notifyDataSetChanged();
    }

    public void add(Series series) {
        mSeriesList.add(series);
    }


    public interface OnCategoryClickListener {
        void onItemClick(View view, int position, Series model);
    }
}
