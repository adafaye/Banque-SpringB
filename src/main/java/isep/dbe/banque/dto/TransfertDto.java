package isep.dbe.banque.dto;
import lombok.Data;
@Data
public class TransfertDto {
    private Long compteSourceId;
    private Long compteDestId;
    private double montant; }