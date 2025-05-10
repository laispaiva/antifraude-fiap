# 🔐 Antifraude - Backend Java (Spring Boot)

Backend desenvolvido para o Challenge FIAP & QUOD - Sprint 2, com foco em validação antifraude de imagens biométricas e documentos.

---

## ✅ Funcionalidades

- Validação de biometria facial e digital
- Validação de documentos (documentoscopia)
- Simulação de tentativas de fraude (ex: deepfake, máscara)
- Persistência em banco NoSQL (MongoDB)
- Notificação automática para o sistema da QUOD via HTTP
- Testes unitários com MockMvc e JUnit 5

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2
- MongoDB
- Maven
- Lombok
- JUnit 5 + Spring Boot Starter Test

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 21 instalado
- MongoDB rodando localmente na porta `27017`
- Git e Maven instalados

### Passos
```bash
# Clone o projeto
git clone https://github.com/laispaiva/antifraude-fiap.git
cd antifraude-fiap

# Execute o projeto
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:9090`.

---

## 📦 Endpoints principais

### Biometria
- `POST /api/biometria/facial`
- `POST /api/biometria/digital`

### Documentos
- `POST /api/documentos/validar`

### Notificação (interna)
- `POST /api/notificacoes/fraude`

---

## 🧪 Testes

O projeto inclui testes automatizados para os endpoints REST utilizando:
- `@WebMvcTest`
- `MockMvc`
- `ObjectMapper` para serialização de objetos

Para executar os testes:

```bash
mvn test
```

---

## 👤 Responsável

- Nome: Lais Paiva Cunha  
- RM: 552732  
- GitHub: [@laispaiva](https://github.com/laispaiva)