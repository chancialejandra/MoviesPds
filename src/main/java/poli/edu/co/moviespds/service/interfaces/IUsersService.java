package poli.edu.co.moviespds.service.interfaces;

import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.dto.request.UserRequest;
import poli.edu.co.moviespds.entity.Users;

import java.util.List;

public interface IUsersService {

    Boolean findByIdentificationNumber(String identificationNumber);
    MessageResponse createUser(UserRequest user);

    List<Users> fillAllUser();

    MessageResponse deleteUser(String identificationNumber);
}
