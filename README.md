# 🔐 Antifraude - Backend Java (Spring Boot)

Backend desenvolvido para o Challenge FIAP & QUOD - Sprint 2, com foco em validação antifraude de imagens biométricas e documentos.

---

## ✅ Funcionalidades

- Validação de biometria facial e digital
- Validação de documentos (documentoscopia)
- Simulação de tentativas de fraude (ex: deepfake, máscara)
- Persistência em banco NoSQL (MongoDB)
- Notificação automática para o sistema da QUOD via HTTP

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2
- MongoDB
- Maven
- Lombok

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 21 instalado
- MongoDB rodando localmente na porta `27017`
- Git e Maven instalados

### Passos
```bash
# Clone o projeto
git clone <URL_DO_SEU_REPO>
cd antifraude

# Execute com Maven
./mvnw spring-boot:run
A aplicação estará disponível em http://localhost:9090.

📦 Endpoints principais
Biometria
POST /api/biometria/facial

POST /api/biometria/digital

Documentos
POST /api/documentos/validar

Notificação (interna)
POST /api/notificacoes/fraude

🧪 Testes
Por enquanto, testes automatizados não foram incluídos, mas os endpoints podem ser validados via Postman ou Insomnia.

👤 Responsável
Nome: Lais Paiva Cunha
RM: 552732
https://github.com/laispaiva