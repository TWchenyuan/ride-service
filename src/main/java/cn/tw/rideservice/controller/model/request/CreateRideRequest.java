package cn.tw.rideservice.controller.model.request;

public class CreateRideRequest {
    private String userId;

    public CreateRideRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
