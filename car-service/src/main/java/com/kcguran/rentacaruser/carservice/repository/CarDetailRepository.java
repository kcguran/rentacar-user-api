package com.kcguran.rentacaruser.carservice.repository;

import com.kcguran.rentacaruser.carservice.entity.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail,Long> {
}
