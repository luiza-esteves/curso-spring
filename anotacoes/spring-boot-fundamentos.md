# Spring Boot – Anotações Iniciais e Fundamentos

Estas anotações reúnem os conceitos fundamentais do **Spring Boot** e do **Spring Framework**, servindo como base para o desenvolvimento de aplicações Java modernas, escaláveis e alinhadas com o mercado.

---

## O que é Spring Boot?

O **Spring Boot** é um framework que simplifica o desenvolvimento de aplicações Java baseadas no **Spring Framework**, reduzindo configurações manuais e acelerando o start de novos projetos.

### Principais características:
- Arquitetura baseada em **módulos (starters)**
- Configuração automática (auto-configuration)
- Foco em produtividade
- Ideal para APIs REST e aplicações backend modernas

---

## 📦 Starters do Spring Boot

O Spring Boot é dividido em **starters**, que são dependências pré-configuradas para resolver problemas específicos.

A aplicação só carrega **os módulos realmente necessários**, deixando o projeto mais leve e organizado.

### Starters mais utilizados

#### 1️⃣ `spring-boot-starter-web`
Utilizado para:
- Desenvolvimento de **APIs REST**
- Aplicações web
- Controllers (`@RestController`)
- Servidor embutido (Tomcat por padrão)

Inclui:
- Spring MVC
- Jackson (JSON)
- Validação básica de requisições

---

#### 2️⃣ `spring-boot-starter-data-jpa`
Utilizado para:
- Acesso a dados
- Persistência em bancos relacionais

Principais conceitos:
- **JPA (Java Persistence API)**
- **Hibernate** como implementação padrão
- ORM (Object-Relational Mapping)
- Mapeamento de objetos Java para tabelas do banco

Funcionalidades:
- `JpaRepository`
- Query Methods
- Abstração do SQL
- Gerenciamento automático de transações

---

#### 3️⃣ `spring-boot-starter-security`
Utilizado para:
- Segurança da aplicação
- Autenticação e autorização

Principais recursos:
- Spring Security
- OAuth2
- JWT
- Controle de acesso baseado em roles e permissões
- Proteção de endpoints REST

---

#### 4️⃣ `spring-boot-starter-test`
Utilizado para:
- Testes automatizados

Inclui:
- **JUnit** (testes unitários)
- **Mockito** (mock de dependências)
- Spring Test Context

Permite:
- Testes de unidade
- Testes de integração
- Garantia de qualidade do código

---

#### 5️⃣ `spring-boot-starter-validation`
Utilizado para:
- Validação de dados de entrada

Baseado em:
- **Bean Validation**

Exemplos de validação:
- `@NotNull`
- `@NotBlank`
- `@Size`
- `@Email`

Muito utilizado em:
- Requisições de APIs REST

---

## Spring Framework

O **Spring Framework** é o core de todo o ecossistema Spring.  
O Spring Boot é uma camada que abstrai e facilita seu uso.

### Características principais:
- Framework para aplicações **complexas e escaláveis**
- Baseado em boas práticas de arquitetura
- Extremamente modular

---

## Injeção de Dependência (DI)

A **Injeção de Dependência** permite que objetos recebam suas dependências sem criá-las diretamente.

Benefícios:
- Código mais desacoplado
- Facilidade de testes
- Manutenção simplificada

