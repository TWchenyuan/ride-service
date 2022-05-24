package cn.tw.rideservice.repository;

import cn.tw.rideservice.AbstractTestBase;
import cn.tw.rideservice.repository.entity.RideEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import static cn.tw.rideservice.service.model.Ride.createRide;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class RideRepositoryTest extends AbstractTestBase {
    @Autowired
    private RideRepository rideRepository;

    @Test
    void should_save_to_db_when_save_ride() {
        var ride = createRide("user-id-1","proposal-id-1");

       var result= rideRepository.save(ride);

        var query = (RideEntity)this.jdbcTemplate.queryForObject(
                "select * from ride where ride_id = ?",
                new Object[] {ride.getRideId()},
                new BeanPropertyRowMapper<>(RideEntity.class)
                );
        assertNotNull(query);
        assertEquals(query.getRideId(), result.getRideId());

    }
}
