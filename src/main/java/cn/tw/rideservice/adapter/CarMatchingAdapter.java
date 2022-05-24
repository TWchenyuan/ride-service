package cn.tw.rideservice.adapter;

import cn.tw.rideservice.adapter.dto.MatchingDto;

public interface CarMatchingAdapter {
    MatchingDto queryMatching(String proposalId);
}
