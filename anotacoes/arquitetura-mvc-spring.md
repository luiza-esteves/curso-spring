# Estrutura de Projeto Spring Boot – Arquitetura MVC

## Visão Geral da Arquitetura

A aplicação é dividida em **camadas**, onde cada uma possui uma responsabilidade bem definida:


## Camadas da Aplicação

### 1. Controller (Camada de Aplicação / API)

- Implementada com **@RestController**
- Responsável por:
    - Receber requisições HTTP (GET, POST, PUT, DELETE, etc.)
    - Converter dados de entrada (JSON → objetos Java)
    - Retornar respostas HTTP adequadas (status + corpo)

 **Boas práticas**:
- Não conter lógica de negócio
- Não acessar diretamente o banco de dados
- Apenas orquestrar a chamada para a camada de serviço

Exemplo de responsabilidades:
- Validar formato da requisição
- Chamar o Service correto
- Retornar `ResponseEntity`

---

### 2. Service (Camada de Negócio)

- Implementada com **@Service**
- Responsável por:
    - Conter a **lógica de negócio**
    - Processar regras, validações e fluxos
    - Coordenar chamadas entre diferentes componentes
    - Decidir quando e como acessar repositórios ou APIs externas

 Observações importantes:
- Um Service **nem sempre precisa acessar um repositório**
- Pode consumir:
    - APIs externas
    - Serviços internos
    - Validadores
    - Outros serviços

 Essa camada é importante ter em aplicações médias e grandes, pois centraliza o comportamento do sistema.

---

### 3. Repository (Camada de Persistência)

- Implementada com **@Repository** ou interfaces que estendem `JpaRepository`
- Responsável por:
    - Acesso direto à base de dados
    - Operações de CRUD (Create, Read, Update, Delete)

A persistência não se limita apenas a banco de dados:
- Pode ser:
    - Banco relacional
    - Banco em memória
    - Arquivos CSV
    - Planilhas
    - Arquivos TXT
    - Outros tipos de armazenamento

O Repository **não contém lógica de negócio**, apenas regras de acesso aos dados.

### 4. Base de Dados / Fonte de Dados

- Pode ser:
    - Banco de dados relacional (H2, PostgreSQL, MySQL, etc.)
    - Arquivos
    - Sistemas externos

Essa camada é totalmente isolada das regras de negócio pela camada de repositório.

## Injeção de Dependências

- Services injetam Repositories
- Controllers injetam Services
- Componentes são gerenciados pelo container do Spring

Benefícios:
- Baixo acoplamento
- Código mais testável
- Maior flexibilidade para mudanças futuras

---

## Importância da Camada de Serviço

Embora em aplicações muito simples seja possível injetar um Repository diretamente no Controller, **essa prática não é recomendada** em aplicações reais.

- A camada de Service é fundamental para:
    - Organização
    - Escalabilidade
    - Manutenção
- Facilita a reutilização da lógica de negócio
- Evita Controllers “gordos” e difíceis de testar
