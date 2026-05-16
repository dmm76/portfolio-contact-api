package br.com.monquero.portfolio_contact_api.controller;

import br.com.monquero.portfolio_contact_api.dto.ContactRequest;
import br.com.monquero.portfolio_contact_api.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = {
        "https://www.monquero.dev.br",
        "https://monquero.dev.br",
        "https://portfolio-website-production-c55d.up.railway.app",
        "http://localhost:5173",
        "http://127.0.0.1:5173"
})
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Void> send(
            @RequestBody ContactRequest request
    ) {

        emailService.send(request);

        return ResponseEntity.ok().build();
    }
}