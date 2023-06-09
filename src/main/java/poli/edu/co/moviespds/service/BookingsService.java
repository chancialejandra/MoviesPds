package poli.edu.co.moviespds.service;

import org.springframework.stereotype.Service;
import poli.edu.co.moviespds.dto.request.BookingsRequest;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.entity.Bookings;
import poli.edu.co.moviespds.repository.IBookingsRepository;
import poli.edu.co.moviespds.service.interfaces.IBookingsService;

import java.util.List;
import java.util.Optional;

@Service
public class BookingsService implements IBookingsService {
    private final IBookingsRepository iBookingsRepository;

    public BookingsService(IBookingsRepository iBookingsRepository) {
        this.iBookingsRepository = iBookingsRepository;
    }

    @Override
    public MessageResponse createBookings(BookingsRequest bookingsRequest) {
        return null;
    }

    @Override
    public List<Bookings> fillAllBookings() {
        return null;
    }

    @Override
    public List<Bookings> findByIdBokings(Long idBookings) {
        return null;
    }

    @Override
    public MessageResponse deleteBookings(Long idBookings) {
        return null;
    }

    @Override
    public Optional<Bookings> findByUserId(Long idBookings) {
        return iBookingsRepository.findByUserId(idBookings);
    }

    @Override
    public Boolean findByIdUser(Long idBookings) {
        if ( iBookingsRepository.findByUserId(idBookings).isPresent()) {
            return true;
        }
        return false;
    }

}

