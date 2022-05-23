package cn.tw.rideservice.controller.model.response;

import java.time.Instant;

public class RideCreatedResponse {
    private String rideId;
    private Instant createdAt;

    public RideCreatedResponse(String rideId, Instant createdAt) {
        this.rideId = rideId;
        this.createdAt = createdAt;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
