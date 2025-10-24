
package isep.dbe.banque.service;
import isep.dbe.banque.dto.CompteDto;
import isep.dbe.banque.dto.TransfertDto;
import isep.dbe.banque.entity.*;
import isep.dbe.banque.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
@Service @RequiredArgsConstructor
public class BanqueService {
    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;
public List<Client> getClients() {
    return clientRepository.findAll(); }
public Optional<Double> getSolde(Long compteId) {
    return compteRepository.findById(compteId).map(Compte::getSolde); }
public Optional<Compte> createCompte(CompteDto dto) {
    Optional<Client> client = clientRepository.findById(dto.getClientId());
    if(client.isPresent()){
        Compte compte = new Compte(); compte.setClient(client.get());
        compte.setSolde(dto.getSolde());
        return Optional.of(compteRepository.save(compte)); }
    return Optional.empty(); }
public void transfere(TransfertDto dto) {
    Compte source = compteRepository.findById(dto.getCompteSourceId()).orElseThrow(()->new IllegalArgumentException("Compte source introuvable")); Compte dest = compteRepository.findById(dto.getCompteDestId()).orElseThrow(()->new IllegalArgumentException("Compte destination introuvable")); if(source.getSolde() < dto.getMontant()) throw new IllegalArgumentException("Solde insuffisant"); source.setSolde(source.getSolde()-dto.getMontant()); dest.setSolde(dest.getSolde()+dto.getMontant()); compteRepository.save(source); compteRepository.save(dest); } }