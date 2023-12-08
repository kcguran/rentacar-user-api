package com.kcguran.rentacaruser.carservice.repository;

import com.kcguran.rentacaruser.carservice.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory,Long> {
}
