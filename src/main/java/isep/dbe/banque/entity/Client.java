
package isep.dbe.banque.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Client
{ @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nom;
private String prenom;
@OneToMany(mappedBy="client")
private List<Compte> comptes; }