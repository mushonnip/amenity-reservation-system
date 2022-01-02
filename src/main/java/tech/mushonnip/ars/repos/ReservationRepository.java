package tech.mushonnip.ars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.mushonnip.ars.domain.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
