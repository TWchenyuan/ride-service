package cn.tw.rideservice.service.model;

import java.time.Instant;

public class Ride {
    private String rideId;
    private String userId;
    private Instant createdAt;

    public String getRideId() {
        return rideId;
    }

    public String getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Ride(String rideId, Instant createdAt) {
        this.rideId = rideId;
        this.createdAt = createdAt;
    }
}
