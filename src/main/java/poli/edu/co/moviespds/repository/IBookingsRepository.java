package poli.edu.co.moviespds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poli.edu.co.moviespds.entity.Bookings;
import poli.edu.co.moviespds.entity.Movies;

import java.util.Optional;

public interface IBookingsRepository extends JpaRepository<Bookings,Long> {

    Optional<Bookings> findByUserId(Long idBookings);
}
