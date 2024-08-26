package dailycodebuffer.authservice.repositories;

import dailycodebuffer.authservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
}
