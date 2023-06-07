package poli.edu.co.moviespds.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.dto.request.UserRequest;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.repository.IUsersRepository;
import poli.edu.co.moviespds.service.interfaces.IUsersService;

import java.util.List;

@Service
public class UsersService implements IUsersService {

    private final IUsersRepository iUsersRepository;
    ModelMapper mapper = new ModelMapper();

    public UsersService(IUsersRepository iUsersRepository) {
        this.iUsersRepository = iUsersRepository;
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
    public List<Users> readUser() {
        return null;
    }

    @Override
    public MessageResponse deleteUser(String identificationNumber) {
        return null;
    }
}
