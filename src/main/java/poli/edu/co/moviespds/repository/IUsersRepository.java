package poli.edu.co.moviespds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poli.edu.co.moviespds.entity.Users;
@Repository
public interface IUsersRepository extends JpaRepository<Users,Long> {
}
