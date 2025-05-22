package com.example.pas_semestergenap.ApiService.Interface;

import com.example.pas_semestergenap.ApiService.TimResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PremierLeagueInterface {
    @GET("/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TimResponse> getAllTeams();
}
