package com.example.pas_semestergenap.ApiService.Interface;

import com.example.pas_semestergenap.ApiService.MatchScheduleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchScheduleInterface {
    @GET("/api/v1/json/3/eventsround.php?id=4328&r=38&s=2024-2025")
    Call<MatchScheduleResponse> getAllSchedule();
}
