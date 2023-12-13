package com.kcguran.rentacaruser.reservationservice.repository;

import com.kcguran.rentacaruser.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
