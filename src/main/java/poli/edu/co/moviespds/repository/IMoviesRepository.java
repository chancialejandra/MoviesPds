package poli.edu.co.moviespds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poli.edu.co.moviespds.entity.Movies;
import poli.edu.co.moviespds.entity.Users;

import java.util.Optional;

public interface IMoviesRepository extends JpaRepository<Movies, Long> {

    Optional<Movies> findByIdMovie(Long idMovie);

    Optional<Movies> findByTitle(String title);

}
