package com.example.pas_semestergenap.ApiService;

import com.google.gson.annotations.SerializedName;

public class MatchScheduleModel {
    @SerializedName("strEvent")
    private String namaEvent;

    @SerializedName("strLeagueBadge")
    private String leagueBadge; // Gambar badge liga

    @SerializedName("strHomeTeamBadge")
    private String homeTeamLogo; // Jika ada data gambar tim tuan rumah
    @SerializedName("strAwayTeamBadge")
    private String awayTeamLogo; // Jika ada data gambar tim tandang

    @SerializedName("dateEvent")
    private String dateEvent;

    // Tambahkan constructor dan getter-setter sesuai dengan field yang diperlukan
    public MatchScheduleModel(String namaEvent, String dateEvent, String homeTeamLogo, String awayTeamLogo, String leagueBadge) {
        this.namaEvent = namaEvent;
        this.dateEvent = dateEvent;
        this.homeTeamLogo = homeTeamLogo;
        this.awayTeamLogo = awayTeamLogo;
        this.leagueBadge = leagueBadge;
    }

    public String getNamaEvent() { return namaEvent; }

    public String getDateEvent() {
        return dateEvent;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public String getLeagueBadge() {
        return leagueBadge;
    }
}
