package reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservationservice.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
