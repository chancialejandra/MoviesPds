package poli.edu.co.moviespds.service.interfaces;

import poli.edu.co.moviespds.dto.request.MovieRequest;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.entity.Movies;

import java.util.List;
import java.util.Optional;

public interface IMoviesService {

    MessageResponse createMovie(MovieRequest movie);

    List<Movies> fillAllMovies();

    Optional<Movies> findByIdMovie(Long id);

    MessageResponse deleteMovie(Long Id);


}
