package poli.edu.co.moviespds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Movies")
public class Movies {

    @Id
    @Column(name = "id_movies")
    private Long idMovies;

    private String title;

    private String director;

    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movies movies)) return false;
        return Objects.equals(getIdMovies(), movies.getIdMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMovies());
    }
}
