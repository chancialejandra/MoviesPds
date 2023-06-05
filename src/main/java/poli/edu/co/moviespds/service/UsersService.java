package poli.edu.co.moviespds.service;

import org.springframework.stereotype.Service;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.repository.IUsersRepository;

@Service
public class UsersService implements IUsersService{

    private final IUsersRepository iUsersRepository;

    public UsersService(IUsersRepository iUsersRepository) {
        this.iUsersRepository = iUsersRepository;
    }

    @Override
    public Users createUser(Users user) {
        return iUsersRepository.save(user);
    }
}
