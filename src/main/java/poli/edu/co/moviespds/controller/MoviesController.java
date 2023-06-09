package poli.edu.co.moviespds.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.edu.co.moviespds.dto.request.MovieRequest;
import poli.edu.co.moviespds.dto.request.UserRequest;
import poli.edu.co.moviespds.entity.Movies;
import poli.edu.co.moviespds.entity.Users;
import poli.edu.co.moviespds.service.interfaces.IMoviesService;
import poli.edu.co.moviespds.service.interfaces.IUsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final IMoviesService iMoviesService;

    public MoviesController(IMoviesService iMoviesService) {
        this.iMoviesService = iMoviesService;
    }

    @GetMapping
    public ResponseEntity fillAllMovies(){
        List<Movies> list = iMoviesService.fillAllMovies();
        if (list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("There are no registered movies");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping()
    public ResponseEntity createMovies( @Valid @RequestBody MovieRequest movie){
        var response = iMoviesService.createMovie(movie);
        return ResponseEntity.status(response.status).body(response);
    }

    @GetMapping("{idMovie}")
    public ResponseEntity fillByIdMovie(@Valid @PathVariable Long idMovie){
        Optional<Movies> list = iMoviesService.findByIdMovie(idMovie);
        if (list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("There are no registered movies");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/{idMovie}")
    public ResponseEntity deleteMovie(@Valid @PathVariable Long idMovie){
        var response = iMoviesService.deleteMovie(idMovie);
        return ResponseEntity.status(response.status).body(response);
    }


}
