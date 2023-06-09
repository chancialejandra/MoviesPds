package poli.edu.co.moviespds.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.dto.request.UserRequest;
import poli.edu.co.moviespds.entity.Bookings;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.repository.IUsersRepository;
import poli.edu.co.moviespds.service.interfaces.IBookingsService;
import poli.edu.co.moviespds.service.interfaces.IUsersService;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {

    private final IUsersRepository iUsersRepository;
    private final IBookingsService iBookingsService;
    ModelMapper mapper = new ModelMapper();

    public UsersService(IUsersRepository iUsersRepository, IBookingsService iBookingsService) {
        this.iUsersRepository = iUsersRepository;
        this.iBookingsService = iBookingsService;
    }

    @Override
    public Boolean findByIdentificationNumber(String identificationNumber) {
        if (iUsersRepository.findByIdentificationNumber(identificationNumber).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public MessageResponse createUser(UserRequest user) {
        Users users = mapper.map(user,Users.class);
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(!findByIdentificationNumber(user.getIdentificationNumber())){
                iUsersRepository.save(users);
                responseMessage = MessageResponse.builder()
                            .message("Successful registration")
                            .status(HttpStatus.OK)
                            .build();
                    return responseMessage;
            }else{
                return MessageResponse.builder()
                        .message("User already exists")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }catch(Exception ex){
            responseMessage = MessageResponse.builder()
                    .message("Error creating user")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public List<Users> fillAllUser() {
        return iUsersRepository.findAll();
    }

    @Override
    public MessageResponse deleteUser(String identificationNumber) {
        MessageResponse responseMessage = MessageResponse.builder().build();
        Optional<Users> optionalUser = iUsersRepository.findByIdentificationNumber(identificationNumber);

        if (optionalUser.isPresent()) {


            //Eliminar Bookings asociadas
            List<Bookings> bookings = iBookingsService.fillAllBookings();
            for (Bookings bookings1 : bookings) {
                if (bookings1.getUsers().getIdentificationNumber() == identificationNumber) {
                    iBookingsService.deleteBookings(bookings1.getIdBookings());
                }
            }
            iUsersRepository.deleteById(optionalUser.get().getIdUser());
            responseMessage = MessageResponse.builder()
                    .message("User Deleted")
                    .status(HttpStatus.OK)
                    .build();
        } else {
            responseMessage = MessageResponse.builder()
                    .message("Cannot delete user, no user exists with" +
                            "an identification number: " + identificationNumber)
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return responseMessage;

    }
}
