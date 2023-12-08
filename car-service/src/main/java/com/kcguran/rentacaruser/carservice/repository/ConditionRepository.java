package com.kcguran.rentacaruser.carservice.repository;

import com.kcguran.rentacaruser.carservice.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
}