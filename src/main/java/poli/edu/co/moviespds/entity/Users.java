package poli.edu.co.moviespds.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "identification_number")
    private String identificationNumber;

    private  String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Bookings> bookings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return Objects.equals(getIdUser(), users.getIdUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser());
    }
}
