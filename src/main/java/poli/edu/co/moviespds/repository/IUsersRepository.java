package poli.edu.co.moviespds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poli.edu.co.moviespds.entity.Users;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByIdentificationNumber(String identificationNumber);

}
