package cn.tw.rideservice.service;

import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.service.model.Ride;

public interface RideService {

    Ride createRide(String proposalId, String userId);
}
