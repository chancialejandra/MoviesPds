package poli.edu.co.moviespds.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter

@Table(name = "Bookings")
public class Bookings {

    @Id
    @Column(name = "id_booking")
    private Long idBookings;

    private Long userId;

    private Long showTimeId;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idMovies")
    private Movies movies;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idUser")
    private Users users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookings bookings)) return false;
        return Objects.equals(getIdBookings(), bookings.getIdBookings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBookings());
    }
}
