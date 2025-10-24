package isep.dbe.banque.repository;
import isep.dbe.banque.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {}