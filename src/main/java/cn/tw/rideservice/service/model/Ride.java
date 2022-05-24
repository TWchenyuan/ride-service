package cn.tw.rideservice.service.model;

import cn.tw.rideservice.repository.entity.RideEntity;

import java.time.Instant;
import java.util.UUID;

public class Ride {
    private String rideId;
    private String userId;
    private String proposalId;
    private Instant createdAt;

    private Ride(String userId, String proposalId) {
        this.rideId = UUID.randomUUID().toString();
        this.userId = userId;
        this.proposalId = proposalId;
        this.createdAt = Instant.now();
    }

    private Ride(String rideId, String userId, String proposalId, Instant createdAt) {
        this.rideId = rideId;
        this.userId = userId;
        this.proposalId = proposalId;
        this.createdAt = createdAt;
    }

    public static Ride createRide(String userId, String proposalId) {
        return new Ride(userId, proposalId);
    }

    public static Ride fromEntity(RideEntity entity) {
       return new Ride(entity.getRideId(), entity.getUserId(), entity.getProposalId(), entity.getCreatedAt());
    }

    public String getRideId() {
        return rideId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProposalId() {
        return proposalId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
