package com.example.pas_semestergenap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.pas_semestergenap.ApiService.MatchScheduleModel;
import com.example.pas_semestergenap.ApiService.TimModel;

import java.util.ArrayList;

public class MatchScheduleAdapter extends RecyclerView.Adapter<MatchScheduleAdapter.ViewHolder> {

    private final ArrayList<MatchScheduleModel> listSchedule;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(TimModel clubModel);
    }

    public MatchScheduleAdapter(ArrayList<MatchScheduleModel> listSchedule, OnItemClickListener listener) {
        this.listSchedule = listSchedule;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_match_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchScheduleModel schedule = listSchedule.get(position);
        holder.tvNamaClub.setText(schedule.getNamaEvent());
        holder.tvStadion.setText(schedule.getDateEvent());

        Glide.with(holder.itemView.getContext())
                .load(schedule.getHomeTeamLogo())
                .into(holder.ivClub);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(club));
    }

    @Override
    public int getItemCount() {
        return listClub.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaClub;
        TextView tvStadion;
        ImageView ivClub;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNamaClub = itemView.findViewById(R.id.tvNamaClub);
            tvStadion = itemView.findViewById(R.id.tvDeskripsiClub);
            ivClub = itemView.findViewById(R.id.ivClub);
        }
    }
}