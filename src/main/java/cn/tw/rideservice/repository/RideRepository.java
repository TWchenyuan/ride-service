package cn.tw.rideservice.repository;

import cn.tw.rideservice.repository.entity.RideEntity;
import cn.tw.rideservice.service.model.Ride;

public interface RideRepository {
   RideEntity save(Ride ride) ;
}
