package cn.tw.rideservice.integration;

import cn.tw.rideservice.AbstractTestBase;
import cn.tw.rideservice.adapter.dto.MatchingDto;
import cn.tw.rideservice.adapter.impl.CarMatchingAdapterImpl;
import cn.tw.rideservice.controller.model.request.CreateRideRequest;
import cn.tw.rideservice.controller.model.response.RideCreatedResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class RideIntegrationTest extends AbstractTestBase {

    @MockBean
    private CarMatchingAdapterImpl carMatchingAdapter;
    @Test
    void should_create_ride_success_with_right_proposal() throws JsonProcessingException {
        var baseUrl = "http://localhost:" + this.randomServerPort;
        var userId = "user_id_1";
        var request = new CreateRideRequest(userId);
        var rideRequestId = "ride_request_id_1";
        var proposalId = "proposal_id_1";

        var matchingDto = new MatchingDto(proposalId, "driver_id", BigDecimal.valueOf(100), 100L);

        when(carMatchingAdapter.queryMatching(any())).thenReturn(matchingDto);


        var result = this.restTemplate
                .postForEntity(baseUrl + "/ride-requests/" + rideRequestId + "/proposals/" + proposalId + "/contract",
                        request, RideCreatedResponse.class);
        System.out.println(result.toString());
        assertEquals(201, result.getStatusCodeValue());

    }

}
