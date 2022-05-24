package cn.tw.rideservice.adapter;

import cn.tw.rideservice.adapter.dto.MatchingDto;
import org.springframework.stereotype.Component;

public interface CarMatchingAdapter {
    MatchingDto queryMatching(String proposalId);
}
