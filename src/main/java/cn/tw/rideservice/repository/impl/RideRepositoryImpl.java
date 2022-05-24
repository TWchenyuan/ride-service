package cn.tw.rideservice.repository.impl;

import cn.tw.rideservice.repository.RideRepository;
import cn.tw.rideservice.repository.entity.RideEntity;
import cn.tw.rideservice.repository.mapper.RideMapper;
import cn.tw.rideservice.service.model.Ride;
import org.springframework.stereotype.Repository;

@Repository
public class RideRepositoryImpl implements RideRepository {
    private final RideMapper rideMapper;

    public RideRepositoryImpl(RideMapper rideMapper) {
        this.rideMapper = rideMapper;
    }

    @Override
    public RideEntity save(Ride ride) {
        var entity = new RideEntity(ride.getRideId(), ride.getUserId(), ride.getProposalId(), ride.getCreatedAt());
        return this.rideMapper.save(entity);
    }
}
