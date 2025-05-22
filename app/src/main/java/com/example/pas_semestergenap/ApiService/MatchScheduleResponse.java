package com.example.pas_semestergenap.ApiService;

import java.util.List;

public class MatchScheduleResponse {
    private List<MatchScheduleModel> schedule;

    public List<MatchScheduleModel> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<MatchScheduleModel> schedule) {
        this.schedule = schedule;
    }
}
