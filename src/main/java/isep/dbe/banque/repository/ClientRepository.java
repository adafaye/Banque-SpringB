package isep.dbe.banque.repository;
import isep.dbe.banque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}