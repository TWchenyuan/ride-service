package cn.tw.rideservice.service;


import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.adapter.impl.CarMatchingAdapterImpl;
import cn.tw.rideservice.repository.RideRepository;
import cn.tw.rideservice.repository.entity.RideEntity;
import cn.tw.rideservice.repository.impl.RideRepositoryImpl;
import cn.tw.rideservice.service.impl.RideServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RideServiceTest {
    private CarMatchingAdapter stubAdapter;
    private RideRepository stubRepository;
    private RideService rideService;


    @BeforeEach
    void setUp() {
        this.stubAdapter = mock(CarMatchingAdapterImpl.class);
        this.stubRepository = mock(RideRepositoryImpl.class);
        this.rideService = new RideServiceImpl(this.stubAdapter, this.stubRepository);
    }

    @Test
    void should_query_proposal_when_create_ride() {
        var userId = "user-id-1";
        var proposalId = "proposal-id-1";

        var mockedEntity = new RideEntity("ride-id", "user-id", proposalId, now());
        when(this.stubRepository.save(any())).thenReturn(mockedEntity);

        var result = this.rideService.createRide(proposalId, userId);

        assertNotNull(result);
        assertEquals(result.getRideId(), "ride-id");
        assertEquals(result.getProposalId(), proposalId);
    }
}
