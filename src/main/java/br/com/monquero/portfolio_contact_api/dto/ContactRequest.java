package br.com.monquero.portfolio_contact_api.dto;

public record ContactRequest(
        String nome,
        String email,
        String mensagem
) {
}
