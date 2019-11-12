package Restaurant.Restaurant.User.repository;

import Restaurant.Restaurant.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    @Modifying
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.username = ?3, password = ?4 where u.id = ?5")
    void update(String firstname, String lastname, String username,String password);


}
