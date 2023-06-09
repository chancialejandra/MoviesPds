package poli.edu.co.moviespds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Movies")
public class Movies {

    @Id
    @Column(name = "id_movie")
    private Long idMovie;

    private String title;

    private String director;

    private int rating;

    @OneToMany(mappedBy = "movies",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Showtimes> showtimes;

    @OneToMany(mappedBy = "movies",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Bookings> bookings;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movies movies)) return false;
        return Objects.equals(getIdMovie(), movies.getIdMovie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMovie());
    }
}
