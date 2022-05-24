package cn.tw.rideservice.repository.mapper;

import cn.tw.rideservice.repository.entity.RideEntity;
import org.springframework.data.repository.CrudRepository;

public interface RideMapper extends CrudRepository<RideEntity, String> {
}
