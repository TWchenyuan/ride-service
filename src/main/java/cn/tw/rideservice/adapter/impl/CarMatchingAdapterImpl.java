package cn.tw.rideservice.adapter.impl;

import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.adapter.dto.MatchingDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class CarMatchingAdapterImpl implements CarMatchingAdapter {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://matching-service";

    public CarMatchingAdapterImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public MatchingDto queryMatching(String proposalId) {
        // HTTP client call
        return this.restTemplate.getForObject(baseUrl + "/ride-proposals?proposalId=" + proposalId, MatchingDto.class);
    }
}
