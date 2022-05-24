package cn.tw.rideservice.repository.impl;

import cn.tw.rideservice.repository.RideRepository;
import cn.tw.rideservice.repository.entity.RideEntity;
import cn.tw.rideservice.service.model.Ride;
import org.springframework.stereotype.Repository;

@Repository
public class RideRepositoryImpl implements RideRepository {

    @Override
    public RideEntity save(Ride ride) {
        return null;
    }
}
