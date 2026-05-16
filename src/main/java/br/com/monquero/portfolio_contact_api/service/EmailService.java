package br.com.monquero.portfolio_contact_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.resend.Resend;
import com.resend.services.emails.model.SendEmailRequest;

import br.com.monquero.portfolio_contact_api.dto.ContactRequest;

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
                        request.mensagem()))
                .build();

        try {
            resend.emails().send(email);
            System.out.println("E-mail enviado pela Resend");
        } catch (Exception e) {
            System.out.println("Erro ao enviar e-mail pela Resend");
            e.printStackTrace();
            throw new RuntimeException("Erro ao enviar e-mail pela Resend", e);
        }
    }
}