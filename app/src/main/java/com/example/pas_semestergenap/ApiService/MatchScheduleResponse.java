package com.example.pas_semestergenap.ApiService;

import java.util.List;

public class MatchScheduleResponse {
    private List<MatchScheduleModel> schedule;

    public List<MatchScheduleModel> getTeams() {
        return schedule;
    }

    public void setTeams(List<MatchScheduleModel> schedule) {
        this.schedule = schedule;
    }
}
