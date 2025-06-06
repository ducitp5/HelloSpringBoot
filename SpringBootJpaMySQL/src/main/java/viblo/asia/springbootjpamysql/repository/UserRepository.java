package viblo.asia.springbootjpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import viblo.asia.springbootjpamysql.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByAtk(int atk);

    List<User> findAllByAgiBetween(int start, int end);

    @Query("SELECT u FROM User u WHERE u.def = :def2")
    User findUserByDefQuery(@Param("def2") Integer de);

    List<User> findAllByAgiGreaterThan(int agiThreshold);
}
