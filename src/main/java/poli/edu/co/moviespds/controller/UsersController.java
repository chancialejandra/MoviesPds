package poli.edu.co.moviespds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.service.IUsersService;

@RestController
public class UsersController {

    private final IUsersService iUsersService;

    public UsersController(IUsersService iUsersService) {
        this.iUsersService = iUsersService;
    }

    @PostMapping()
    public Users createUser(@RequestBody Users user){
        return iUsersService.createUser(user);
    }
}
