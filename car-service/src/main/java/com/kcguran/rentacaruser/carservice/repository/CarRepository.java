package com.kcguran.rentacaruser.carservice.repository;

import com.kcguran.rentacaruser.carservice.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
