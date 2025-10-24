package isep.dbe.banque.repository;
import isep.dbe.banque.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, String> {}