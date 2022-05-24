package cn.tw.rideservice.controller;

import cn.tw.rideservice.controller.model.request.CreateRideRequest;
import cn.tw.rideservice.service.RideService;
import cn.tw.rideservice.service.impl.RideServiceImpl;
import cn.tw.rideservice.service.model.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cn.tw.rideservice.service.model.Ride.createRide;
import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class RideControllerTest {
    private RideController rideController;
    private RideService stubService;

    @BeforeEach
    void setUp() {
        this.stubService = mock(RideServiceImpl.class);
        this.rideController = new RideController(this.stubService);
    }

    @Test
    void should_create_ride_when_user_confirm_the_valid_proposal() {

        var userId = "user-id-1";
        var proposalId = "proposal-id-1";

        when(this.stubService.createRide(proposalId, userId)).thenReturn(createRide(userId, proposalId));

        var result = this.rideController.createRide(
                "ride-request-id-1",
                proposalId,
                new CreateRideRequest(userId
                ));
        assertNotNull(result);
        assertNotNull(result.getRideId());
    }
}
