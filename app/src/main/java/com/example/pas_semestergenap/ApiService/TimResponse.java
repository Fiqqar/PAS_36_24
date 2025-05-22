package com.example.pas_semestergenap.ApiService;

import java.util.List;

public class TimResponse {
    private List<TimModel> teams;

    public List<TimModel> getTeams() {
        return teams;
    }

    public void setTeams(List<TimModel> teams) {
        this.teams = teams;
    }
}
