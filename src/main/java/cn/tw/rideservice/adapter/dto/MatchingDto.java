package cn.tw.rideservice.adapter.dto;

import java.math.BigDecimal;

public class MatchingDto {
    private String proposalId;
    private String driverId;
    private BigDecimal estimatedPrice;
    private Long estimatedArrivedTime;

    public MatchingDto(String proposalId, String driverId, BigDecimal estimatedPrice, Long estimatedArrivedTime) {
        this.proposalId = proposalId;
        this.driverId = driverId;
        this.estimatedPrice = estimatedPrice;
        this.estimatedArrivedTime = estimatedArrivedTime;
    }

    public String getProposalId() {
        return proposalId;
    }

    public void setProposalId(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Long getEstimatedArrivedTime() {
        return estimatedArrivedTime;
    }

    public void setEstimatedArrivedTime(Long estimatedArrivedTime) {
        this.estimatedArrivedTime = estimatedArrivedTime;
    }
}
