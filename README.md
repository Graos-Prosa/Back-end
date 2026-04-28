# ☕ Grãos & Prosa - Backend

Backend desenvolvido para a empresa **Grãos & Prosa**, com foco em escalabilidade, desacoplamento e boas práticas de arquitetura.
## 📖 Sobre o Projeto

O **Grãos & Prosa - Backend** é uma API REST desenvolvida para dar suporte a uma plataforma de e-commerce voltada ao segmento de cafés e produtos relacionados. A aplicação foi projetada com foco em **escalabilidade, desacoplamento e manutenibilidade**, seguindo boas práticas amplamente utilizadas no mercado.

A arquitetura é baseada em camadas bem definidas, separando responsabilidades entre **controladores, serviços e repositórios**, além do uso de **DTOs** para garantir segurança e organização na comunicação dos dados.

O sistema contempla funcionalidades essenciais de um e-commerce, como:
- Gestão de usuários e autenticação com **JWT**
- Cadastro e gerenciamento de produtos
- Criação e acompanhamento de pedidos
- Controle de itens e pagamentos
- Gerenciamento de cupons e endereços

Além disso, o projeto integra tecnologias modernas para tornar a aplicação mais robusta:
- **RabbitMQ** para comunicação assíncrona entre serviços
- **WebClient** para consumo de APIs externas (ViaCEP)
- **Login social com Google**
- **Swagger / OpenAPI** para documentação interativa da API
- Estrutura preparada para futuras integrações com **PagBank** (pagamentos) e **Elasticsearch** (busca avançada)

Outro ponto relevante é a preocupação com qualidade de código e boas práticas, incluindo:
- Tratamento de exceções com classes específicas
- Separação clara de responsabilidades (SRP)
- Código desacoplado e preparado para testes
- Uso de Data Seed para facilitar o ambiente de desenvolvimento

---

## 🚀 Tecnologias Utilizadas

- Java + Spring Boot
- Spring Data JPA
- PostgreSQL
- RabbitMQ (mensageria)
- JWT (autenticação e autorização)
- WebClient (integração com ViaCEP)
- Google API (login social)
- Swagger / OpenAPI (documentação)
- Docker
- Data Seed

### 🔮 Futuro

- Elasticsearch
- Integração com PagBank

---

## 🧠 Arquitetura

O projeto segue uma arquitetura em camadas:

- **Controller** → Endpoints REST
- **Service** → Regras de negócio
- **Repository** → Acesso ao banco de dados
- **DTOs** → Entrada e saída de dados
- **Exceptions** → Tratamento de erros customizado

---

## 📦 Entidades

- Usuário
- Credencial
- Endereço
- Produto
- Pedido
- Item
- Pagamento
- Cupom

---

## 🔐 Autenticação

- JWT (Token Bearer)
- Login com email e senha
- Login com Google

---

## 🔄 Integrações

- ViaCEP → Consulta de endereço por CEP
- RabbitMQ → Comunicação assíncrona
- (Futuro) PagBank → Pagamentos
- (Futuro) Elasticsearch → Busca avançada

---

## 📡 Endpoints da API

Abaixo estão os principais endpoints disponíveis na aplicação.

| Verbo HTTP | Endpoint                     | Descrição                          |
|------------|------------------------------|------------------------------------|
| **Auth**   |                              |                                    |
| POST       | /auth/registro               | Registro de novo usuário           |
| POST       | /auth/login                  | Login com email e senha            |
| POST       | /auth/google                 | Login com Google                   |
| **Credencial** |                          |                                    |
| GET        | /credenciais                 | Lista todas as credenciais         |
| GET        | /credenciais/{id}            | Busca credencial por ID            |
| PATCH      | /credenciais/{id}            | Atualiza credencial                |
| DELETE     | /credenciais/{id}            | Remove credencial                  |
| **Cupom**  |                              |                                    |
| GET        | /cupons                      | Lista cupons                       |
| GET        | /cupons/{id}                 | Busca cupom por ID                 |
| POST       | /cupons                      | Cria cupom                         |
| PATCH      | /cupons/{id}                 | Atualiza cupom                     |
| DELETE     | /cupons/{id}                 | Remove cupom                       |
| **Endereço** |                            |                                    |
| GET        | /enderecos                   | Lista endereços                    |
| GET        | /enderecos/{id}              | Busca endereço por ID              |
| POST       | /enderecos                   | Cria endereço                      |
| PATCH      | /enderecos/{id}              | Atualiza endereço                  |
| DELETE     | /enderecos/{id}              | Remove endereço                    |
| **Item**   |                              |                                    |
| GET        | /itens                       | Lista itens                        |
| GET        | /itens/{id}                  | Busca item por ID                  |
| POST       | /itens                       | Cria item                          |
| PATCH      | /itens/{id}                  | Atualiza item                      |
| DELETE     | /itens/{id}                  | Remove item                        |
| **Pagamento** |                          |                                    |
| GET        | /pagamentos                  | Lista pagamentos                   |
| GET        | /pagamentos/{id}             | Busca pagamento por ID             |
| PATCH      | /pagamentos/{id}             | Atualiza pagamento                 |
| DELETE     | /pagamentos/{id}             | Remove pagamento                   |
| **Pedido** |                              |                                    |
| GET        | /pedidos                     | Lista pedidos                      |
| GET        | /pedidos/{id}                | Busca pedido por ID                |
| POST       | /pedidos                     | Cria pedido                        |
| PATCH      | /pedidos/{id}                | Atualiza pedido                    |
| DELETE     | /pedidos/{id}                | Remove pedido                      |
| GET        | /pedidos/{id}/itens          | Lista itens do pedido              |
| GET        | /pedidos/{id}/pagamento      | Busca pagamento do pedido          |
| **Produto** |                             |                                    |
| GET        | /produtos                    | Lista produtos                     |
| GET        | /produtos/{id}               | Busca produto por ID               |
| POST       | /produtos                    | Cria produto                       |
| PATCH      | /produtos/{id}               | Atualiza produto                   |
| DELETE     | /produtos/{id}               | Remove produto                     |
| **Usuário** |                             |                                    |
| GET        | /usuarios                    | Lista usuários                     |
| GET        | /usuarios/{id}               | Busca usuário por ID               |
| PUT        | /usuarios/{id}               | Atualiza usuário                   |
| DELETE     | /usuarios/{id}               | Remove usuário                     |
| GET        | /usuarios/{id}/enderecos     | Lista endereços do usuário         |
| GET        | /usuarios/{id}/pedidos       | Lista pedidos do usuário           |

---
## 📄 Documentação da API (Swagger)

A API possui documentação interativa utilizando **Swagger (OpenAPI)**.

Com ela, é possível:
- Visualizar todos os endpoints disponíveis
- Testar requisições diretamente pelo navegador
- Ver parâmetros, exemplos e respostas

---

### 🌐 Acesso ao Swagger

- **Swagger UI**
- **OpenAPI JSON**

## 🐳 Hosteamento e Configuração

A aplicação utiliza Docker para provisionar os serviços de banco de dados e mensageria.

---

### 📦 Serviços

- **PostgreSQL**
  - Container: `banco-postgres`
  - Porta: `5432`
  - Responsável pelo armazenamento dos dados da aplicação

- **RabbitMQ**
  - Container: `rabbitmq`
  - Portas:
    - `5672` → comunicação da aplicação
    - `15672` → painel web de administração

---

### 🌐 Portas Utilizadas

| Serviço        | Porta | Descrição                        | Link de acesso ao rodar o projeto     |
|----------------|-------|----------------------------------|---------------------------------------|
| API            | 8080  | Sistema                          | http://localhost:8080                 |
| PostgreSQL     | 5432  | Banco de dados                   | http://localhost:5432                 |
| RabbitMQ       | 5672  | Comunicação (mensageria)         | http://localhost:5672                 |
| RabbitMQ       | 15672 | Painel de administração (Web UI) | http://localhost:15672                |
| Swagger (UI)   | 8080  | Painel de Documentação  (Web UI) | http://localhost:8080/swagger-ui.html |
| OpenAPI (JSON) | 8080  | Painel de Documentação  (JSON)   | http://localhost:8080/v3/api-docs     |

---

### ⚙️ Variáveis de Ambiente (.env)

Configure o arquivo `.env` com os seguintes valores:

- **PostgreSQL**
  - `POSTGRES_USER`
  - `POSTGRES_PASSWORD`
  - `POSTGRES_DB`

- **RabbitMQ**
  - `RABBITMQ_DEFAULT_USER`
  - `RABBITMQ_DEFAULT_PASS`

---

## ▶️ Como Executar o Projeto

Siga os passos abaixo para rodar o projeto localmente.

---

### 📋 Pré-requisitos

- Java 17+
- Maven
- Docker

---

### ⚙️ Configuração

1. Crie um arquivo `.env` na raiz do projeto
2. Configure as variáveis necessárias:

- PostgreSQL
  - `POSTGRES_USER`
  - `POSTGRES_PASSWORD`
  - `POSTGRES_DB`

- RabbitMQ
  - `RABBITMQ_DEFAULT_USER`
  - `RABBITMQ_DEFAULT_PASS`

---

### 🐳 Subindo os Serviços

Suba os containers do PostgreSQL e RabbitMQ via Docker.

---

### 🚀 Executando a Aplicação

Inicie a aplicação Spring Boot normalmente via Maven ou pela sua IDE.

---

### ✅ Verificação

Após iniciar:

- Verifique se a API está respondendo
- Acesse o painel do RabbitMQ
- Confirme a conexão com o banco PostgreSQL

---

### ⚠️ Observações

- Certifique-se de que as portas `5432`, `5672` e `15672` estão livres
- O `.env` deve estar corretamente configurado antes de subir os serviços

---

## 👨‍💻 Autor

<table>
  <tr>
    <td align="center">
      <h3>Richard Alves</h3>
      <a href="https://github.com/Richard-Alves167" target="_blank">
        <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"/>
      </a>
      <br><br>
      <a href="https://www.linkedin.com/in/richard-alves-dev" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/>
      </a>
    </td>
    <td align="center">
      <h3>Taylan Silva</h3>
      <a href="https://github.com/taylan04" target="_blank">
        <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"/>
      </a>
      <br><br>
      <a href="https://www.linkedin.com/in/taylansilva04/" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"/>
      </a>
    </td>
  </tr>
</table>

---

## O projeto foi desenvolvido com uma visão próxima à de sistemas reais em produção, buscando não apenas atender aos requisitos funcionais, mas também garantir uma base sólida para evolução futura.
