package com.example.pas_semestergenap.ApiService;

import com.google.gson.annotations.SerializedName;

public class TimModel {
    @SerializedName("strTeam")
    private String namaClub;

    @SerializedName("strStadium")
    private String stadion;

    @SerializedName("strBadge")
    private String imageUrl;

    public TimModel(String namaClub, String stadion, String imageUrl) {
        this.namaClub = namaClub;
        this.stadion = stadion;
        this.imageUrl = imageUrl;
    }

    public String getNamaClub() {return namaClub;}

    public String getStadion() {
        return stadion;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
