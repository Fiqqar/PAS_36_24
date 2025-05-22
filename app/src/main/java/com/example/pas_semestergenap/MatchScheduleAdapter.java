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

import java.util.ArrayList;

public class MatchScheduleAdapter extends RecyclerView.Adapter<MatchScheduleAdapter.ViewHolder> {

    private final ArrayList<MatchScheduleModel> listSchedule;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(MatchScheduleModel matchScheduleModel);
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
        holder.tvEventName.setText(schedule.getNamaEvent());
        holder.tvDateEvent.setText(schedule.getDateEvent());

        Glide.with(holder.itemView.getContext())
                .load(schedule.getHomeTeamLogo())
                .into(holder.ivHomeTeam);

        Glide.with(holder.itemView.getContext())
                .load(schedule.getAwayTeamLogo())
                .into(holder.ivAwayTeam);


        holder.itemView.setOnClickListener(v -> listener.onItemClick(schedule));
    }

    @Override
    public int getItemCount() {
        return listSchedule.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHomeTeam;
        TextView tvEventName;
        TextView tvDateEvent;
        ImageView ivAwayTeam;

        public ViewHolder(View itemView) {
            super(itemView);
            ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvDateEvent = itemView.findViewById(R.id.tvDateEvent);
            ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);
        }
    }
}