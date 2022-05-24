package cn.tw.rideservice.service.impl;

import cn.tw.rideservice.adapter.CarMatchingAdapter;
import cn.tw.rideservice.repository.RideRepository;
import cn.tw.rideservice.service.RideService;
import cn.tw.rideservice.service.model.Ride;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    private final CarMatchingAdapter carMatchingAdapter;
    private final RideRepository rideRepository;
    public RideServiceImpl(CarMatchingAdapter carMatchingAdapter, RideRepository rideRepository) {
        this.carMatchingAdapter = carMatchingAdapter;
        this.rideRepository = rideRepository;
    }

    @Override
    public Ride createRide(String proposalId, String userId) {
        var matching = this.carMatchingAdapter.queryMatching(proposalId);
        var newRide = Ride.createRide(userId, proposalId) ;
        var result = this.rideRepository.save(newRide);
        return Ride.fromEntity(result);
    }
}
