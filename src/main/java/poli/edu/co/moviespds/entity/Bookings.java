package poli.edu.co.moviespds.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter

@Table(name = "Bookings")
public class Bookings {

    @Id
    @Column(name = "id_booking")
    private Long idBooking;

    private Long idUser;

    private Long idShowTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookings bookings)) return false;
        return Objects.equals(getIdBooking(), bookings.getIdBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBooking());
    }
}
