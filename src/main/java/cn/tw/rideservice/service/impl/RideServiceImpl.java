package cn.tw.rideservice.service.impl;

import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.service.RideService;
import cn.tw.rideservice.service.model.Ride;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    private final CarMatchingAdapter carMatchingAdapter;
    public RideServiceImpl(CarMatchingAdapter carMatchingAdapter) {
        this.carMatchingAdapter = carMatchingAdapter;
    }

    @Override
    public Ride createRide(String proposalId, String userId) {
        var matching = this.carMatchingAdapter.queryMatching(proposalId);
        return null;
    }
}
