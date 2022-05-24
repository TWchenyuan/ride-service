package cn.tw.rideservice.service;


import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.service.impl.RideServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RideServiceTest {
    private CarMatchingAdapter stubAdapter;
    private RideService rideService;


    @BeforeEach
    void setUp() {
        this.stubAdapter = mock(CarMatchingAdapter.class);
        this.rideService = new RideServiceImpl(this.stubAdapter);
    }

    @Test
    void should_query_proposal_when_create_ride() {
        var userId = "user-id-1";
        var proposalId = "proposal-id-1";

        var result = this.rideService.createRide(proposalId, userId);

        verify(this.stubAdapter, times(1)).queryMatching(proposalId);
    }
}
