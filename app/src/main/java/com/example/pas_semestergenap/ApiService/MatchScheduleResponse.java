package com.example.pas_semestergenap.ApiService;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchScheduleResponse {
    @SerializedName("events")
    private List<MatchScheduleModel> events;

    public List<MatchScheduleModel> getEvents() {
        return events;
    }

    public void setEvents(List<MatchScheduleModel> events) {
        this.events = events;
    }
}
