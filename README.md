# Portfolio Contact API

API REST desenvolvida com Java e Spring Boot para gerenciamento do formulário de contato do portfólio pessoal.

A aplicação recebe mensagens enviadas pelo frontend do portfólio e realiza o envio de e-mails utilizando a API da Resend, seguindo uma arquitetura moderna desacoplada entre frontend e backend.

---

# Arquitetura

```text
Portfolio Frontend
        ↓
Spring Boot REST API
        ↓
Resend API
        ↓
E-mail
```

---

# Tecnologias Utilizadas

## Backend
- Java 21
- Spring Boot 3
- Spring Web
- Maven

## Integrações
- Resend API
- REST APIs
- JSON

## Cloud & Deploy
- Railway
- Variáveis de ambiente

---

# Funcionalidades

- Recebimento de mensagens do formulário de contato
- Integração com serviço transacional de e-mail
- Comunicação frontend/backend via HTTP
- Envio de e-mails em tempo real
- Estrutura desacoplada para deploy independente
- Arquitetura pronta para evolução futura

---

# Endpoint

## Enviar mensagem

```http
POST /contact
```

## Payload

```json
{
  "nome": "Douglas Monquero",
  "email": "contato@email.com",
  "telefone": "(44) 99999-9999",
  "assunto": "Contato pelo portfólio",
  "mensagem": "Olá, gostaria de conversar sobre um projeto."
}
```

---

# Variáveis de Ambiente

A aplicação utiliza variáveis de ambiente para armazenamento seguro de secrets.

## Exemplo

```env
RESEND_API_KEY=re_xxxxxxxxxxxxxxxxx
```

---

# Configuração Local

## Clonar repositório

```bash
git clone https://github.com/dmm76/portfolio-contact-api.git
```

## Entrar na pasta

```bash
cd portfolio-contact-api
```

## Definir variável local (PowerShell)

```powershell
$env:RESEND_API_KEY="re_xxxxxxxxx"
```

## Executar aplicação

### Windows

```bash
mvnw spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

---

# Testando a API

## URL local

```text
http://localhost:8080/contact
```

## Exemplo de requisição

```json
{
  "nome": "Douglas",
  "email": "teste@gmail.com",
  "telefone": "(44) 99999-9999",
  "assunto": "Teste",
  "mensagem": "Funcionando!"
}
```

---

# Integração com Frontend

O frontend do portfólio realiza requisições utilizando `fetch()` para comunicação com a API.

Exemplo:

```javascript
await fetch("http://localhost:8080/contact", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify(data)
});
```

---

# Próximas Evoluções

- Validação avançada de payload
- Rate limiting
- Proteção anti-spam
- Persistência em banco de dados
- Dashboard administrativo
- Logs e observabilidade
- Filas e processamento assíncrono
- Dockerização
- CI/CD

---

# Objetivo do Projeto

Este projeto faz parte da evolução do ecossistema do portfólio pessoal, demonstrando conhecimentos em:

- APIs REST
- Arquitetura desacoplada
- Integração com serviços externos
- Cloud deployment
- Backend Java moderno
- Engenharia de software

---

# Autor

Douglas Marcelo Monquero

- LinkedIn:
https://www.linkedin.com/in/douglas-monquero

- GitHub:
https://github.com/dmm76

- Portfólio:
https://www.monquero.dev.br
