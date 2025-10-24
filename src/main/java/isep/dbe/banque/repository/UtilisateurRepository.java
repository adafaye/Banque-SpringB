package isep.dbe.banque.repository;
import isep.dbe.banque.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> { Optional<Utilisateur> findByUsername(String username); }