
package isep.dbe.banque.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Role
{ @Id private String nom; }