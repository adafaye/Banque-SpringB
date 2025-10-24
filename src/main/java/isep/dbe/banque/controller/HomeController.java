package isep.dbe.banque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bienvenue sur l'API Banque ! Utilisez les endpoints /api/... pour interagir avec le système.";
    }
}
