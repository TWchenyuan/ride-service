package cn.tw.rideservice.controller;

import cn.tw.rideservice.controller.model.request.CreateRideRequest;
import cn.tw.rideservice.controller.model.response.RideCreatedResponse;
import cn.tw.rideservice.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/ride-requests/{rideRequestId}/proposals/{proposalId}/contract")
    @ResponseStatus(CREATED)
    public RideCreatedResponse createRide(@PathVariable("rideRequestId") String rideRequestId,
                                          @PathVariable("proposalId") String proposalId,
                                          @RequestBody() CreateRideRequest request) {
        var ride = this.rideService.createRide(proposalId, request.getUserId());
        return new RideCreatedResponse(ride.getRideId(), ride.getCreatedAt());
    }
}
