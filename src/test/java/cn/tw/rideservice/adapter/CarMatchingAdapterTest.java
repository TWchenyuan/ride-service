package cn.tw.rideservice.adapter;

import cn.tw.rideservice.adapter.dto.MatchingDto;
import cn.tw.rideservice.adapter.impl.CarMatchingAdapterImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest(CarMatchingAdapterImpl.class)
class CarMatchingAdapterTest {
    @Autowired
    private CarMatchingAdapter carMatchingAdapter;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void should_query_proposal_when_proposal_isvalid() throws JsonProcessingException {
        var proposalId = "proposal_id";
        var matchingDto = new MatchingDto(proposalId, "driver_id", BigDecimal.valueOf(100), 100L);
        var bodyString = objectMapper.writeValueAsString(matchingDto);
        this.server.expect(ExpectedCount.once(), requestTo("http://matching-service/ride-proposals?proposalId=" + proposalId))
                .andExpect(method(GET))
                .andRespond(withSuccess(bodyString, APPLICATION_JSON));

        var result = this.carMatchingAdapter.queryMatching(proposalId);
        assertNotNull(result);
        assertEquals(result.getProposalId(), proposalId);
    }
}
