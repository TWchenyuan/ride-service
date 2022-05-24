package cn.tw.rideservice.repository.entity;

import java.time.Instant;

public class RideEntity {
    private String rideId;
    private String userId;
    private String proposalId;
    private Instant createdAt;

    public RideEntity() {
    }

    public RideEntity(String rideId, String userId, String proposalId, Instant createdAt) {
        this.rideId = rideId;
        this.userId = userId;
        this.proposalId = proposalId;
        this.createdAt = createdAt;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
