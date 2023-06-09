package poli.edu.co.moviespds.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import poli.edu.co.moviespds.dto.request.MovieRequest;
import poli.edu.co.moviespds.dto.response.MessageResponse;
import poli.edu.co.moviespds.entity.Movies;
import poli.edu.co.moviespds.repository.IMoviesRepository;
import poli.edu.co.moviespds.service.interfaces.IMoviesService;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService implements IMoviesService {

    private final IMoviesRepository iMoviesRepository;
    ModelMapper mapper = new ModelMapper();


    public MoviesService(IMoviesRepository iMoviesRepository) {
        this.iMoviesRepository = iMoviesRepository;
    }

    public Boolean findByTitle(String title){
        if (iMoviesRepository.findByTitle(title).isPresent()) {
            return true;
        }
        return false;
    }
    @Override
    public MessageResponse createMovie(MovieRequest movie) {
        Movies movies = mapper.map(movie,Movies.class);
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(!findByTitle(movie.getTitle())){
                iMoviesRepository.save(movies);
                responseMessage = MessageResponse.builder()
                        .message("Successful registration")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }else{
                return MessageResponse.builder()
                        .message("movie already exists")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }catch(Exception ex){
            responseMessage = MessageResponse.builder()
                    .message("Error creating movie")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public List<Movies> fillAllMovies() {
        return iMoviesRepository.findAll();
    }

    @Override
    public Optional<Movies> findByIdMovie(Long id) {
        return iMoviesRepository.findByIdMovie(id);
    }

    @Override
    public MessageResponse deleteMovie(Long Id) {
        return null;
    }

}
