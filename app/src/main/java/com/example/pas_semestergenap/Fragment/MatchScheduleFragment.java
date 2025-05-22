package com.example.pas_semestergenap.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_semestergenap.ApiService.Interface.MatchScheduleInterface;
import com.example.pas_semestergenap.ApiService.MatchScheduleModel;
import com.example.pas_semestergenap.ApiService.MatchScheduleResponse;
import com.example.pas_semestergenap.MatchScheduleAdapter;
import com.example.pas_semestergenap.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatchScheduleFragment extends Fragment implements MatchScheduleAdapter.OnItemClickListener {

    private RecyclerView rvListSchedule;
    private MatchScheduleAdapter matchScheduleAdapter;
    private ArrayList<MatchScheduleModel> dataSchedule = new ArrayList<>();
    private ProgressBar pbLoading;

    public MatchScheduleFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler_view1, container, false);

        rvListSchedule = view.findViewById(R.id.rvListClub);
        pbLoading = view.findViewById(R.id.pbLoading);

        setupRecyclerView();
        fetchMatchSchedule();

        return view;
    }

    private void setupRecyclerView() {
        rvListSchedule.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void fetchMatchSchedule() {
        pbLoading.setVisibility(View.VISIBLE);
        rvListSchedule.setVisibility(View.GONE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchScheduleInterface apiService = retrofit.create(MatchScheduleInterface.class);
        Call<MatchScheduleResponse> call = apiService.getAllSchedule();

        call.enqueue(new Callback<MatchScheduleResponse>() {
            @Override
            public void onResponse(Call<MatchScheduleResponse> call, Response<MatchScheduleResponse> response) {
                pbLoading.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    dataSchedule = new ArrayList<>(response.body().getSchedule());
                    matchScheduleAdapter = new MatchScheduleAdapter(dataSchedule, MatchScheduleFragment.this);
                    rvListSchedule.setAdapter(matchScheduleAdapter);
                    rvListSchedule.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getContext(), "Gagal memuat data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MatchScheduleResponse> call, Throwable t) {
                pbLoading.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(MatchScheduleModel matchModel) {
        Toast.makeText(getContext(), matchModel.getNamaEvent() + " - " + matchModel.getDateEvent(), Toast.LENGTH_SHORT).show();
    }
}