package poli.edu.co.moviespds.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.edu.co.moviespds.dto.request.UserRequest;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.service.interfaces.IUsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUsersService iUsersService;

    public UsersController(IUsersService iUsersService) {
        this.iUsersService = iUsersService;
    }

    @GetMapping
    public ResponseEntity readUser(){
        List<Users> list = iUsersService.readUser();
        if (list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("There are no registered users");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody UserRequest user){
        var response = iUsersService.createUser(user);
        return ResponseEntity.status(response.status).body(response);
    }

    @DeleteMapping("/{identificationNumber}")
    public ResponseEntity deleteUser(@Valid @PathVariable String identificationNumber){
        var response = iUsersService.deleteUser(identificationNumber);
        return ResponseEntity.status(response.status).body(response);
    }


}
