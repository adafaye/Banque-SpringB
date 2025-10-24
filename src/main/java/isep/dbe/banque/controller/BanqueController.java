package isep.dbe.banque.controller;

import isep.dbe.banque.dto.*;
import isep.dbe.banque.entity.*;
import isep.dbe.banque.service.BanqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BanqueController {

    private final BanqueService banqueService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(banqueService.getClients());
    }

    @GetMapping("/solde/{compteId}")
    public ResponseEntity<Double> getSolde(@PathVariable Long compteId) {
        return banqueService.getSolde(compteId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCompte(@RequestBody CompteDto dto) {
        return banqueService.createCompte(dto)
                .<ResponseEntity<?>>map(c -> ResponseEntity.status(201).body(c))
                .orElseGet(() -> ResponseEntity.badRequest().body("Client introuvable"));
    }



    @PostMapping("/transfere")
    public ResponseEntity<String> transfere(@RequestBody TransfertDto dto) {
        try {
            banqueService.transfere(dto);
            return ResponseEntity.ok("Transfert effectué");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
