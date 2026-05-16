package br.com.monquero.portfolio_contact_api.service;

import br.com.monquero.portfolio_contact_api.dto.ContactRequest;
import com.resend.Resend;
import com.resend.services.emails.model.SendEmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${resend.api.key}")
    private String apiKey;

    public void send(ContactRequest request) {

        Resend resend = new Resend(apiKey);

        SendEmailRequest email = SendEmailRequest.builder()
                .from("onboarding@resend.dev")
                .to("douglas.monquero@gmail.com")
                .subject("Novo contato do portfólio")
                .html("""
                        <h2>Novo contato</h2>

                        <p><strong>Nome:</strong> %s</p>

                        <p><strong>Email:</strong> %s</p>

                        <p><strong>Mensagem:</strong></p>

                        <p>%s</p>
                        """.formatted(
                                request.nome(),
                                request.email(),
                                request.mensagem()
                        ))
                .build();

        resend.emails().send(email);
    }
}