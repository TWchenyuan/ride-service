package cn.tw.rideservice.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
@Entity
@Table(name= "ride")
public class RideEntity {
    @Id
    @Column(name = "ride_id")
    private String rideId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "proposal_id")
    private String proposalId;
    @Column(name = "created_at")
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
