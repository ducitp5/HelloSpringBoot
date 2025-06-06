package viblo.asia.springboottodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viblo.asia.springboottodo.Entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
