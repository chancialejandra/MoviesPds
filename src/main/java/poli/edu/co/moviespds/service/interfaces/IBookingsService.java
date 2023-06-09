package poli.edu.co.moviespds.service.interfaces;


import poli.edu.co.moviespds.dto.request.BookingsRequest;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.entity.Bookings;

import java.util.List;
import java.util.Optional;

public interface IBookingsService {

    MessageResponse createBookings(BookingsRequest bookingsRequest);
    List<Bookings> fillAllBookings();

    List<Bookings> findByIdBokings(Long idBookings);

    MessageResponse deleteBookings(Long idBookings);

    Optional<Bookings> findByUserId(Long idBookings);

    Boolean findByIdUser(Long idBookings);



}
