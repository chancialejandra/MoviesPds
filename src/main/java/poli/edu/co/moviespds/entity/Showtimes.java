package poli.edu.co.moviespds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter

@Table(name = "Show_Times")
public class Showtimes {

    @Id
    @Column(name = "id_show_time")
    private Long idShowTime;

    private Date date;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idMovies")
    private Movies movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showtimes showtimes)) return false;
        return Objects.equals(getIdShowTime(), showtimes.getIdShowTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdShowTime());
    }
}
