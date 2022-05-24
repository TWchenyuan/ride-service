package cn.tw.rideservice.adapter.impl;

import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.adapter.dto.MatchingDto;
import org.springframework.stereotype.Component;

@Component
public class CarMatchingAdapterImpl implements CarMatchingAdapter {
    @Override
    public MatchingDto queryMatching(String proposalId) {
        // HTTP client call
        return null;
    }
}
