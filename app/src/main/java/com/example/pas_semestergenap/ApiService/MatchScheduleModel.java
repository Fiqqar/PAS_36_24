package com.example.pas_semestergenap.ApiService;

import com.google.gson.annotations.SerializedName;

public class MatchScheduleModel {
    @SerializedName("strEvent")
    private String namaEvent;

    @SerializedName("dateEvent")
    private String dateEvent;

    @SerializedName("strHomeTeamBadge")
    private String homeTeamLogo;

    @SerializedName("strAwayTeamBadge")
    private String awayTeamLogo;



    public MatchScheduleModel(String namaEvent, String dateEvent, String homeTeamLogo, String awayTeamlogo) {
        this.namaEvent = namaEvent;
        this.dateEvent = dateEvent;
        this.homeTeamLogo = homeTeamLogo;
        this.awayTeamLogo = awayTeamlogo;
    }

    public String getNamaEvent() {return namaEvent;}

    public String getDateEvent() {
        return dateEvent;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }
    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }
}
