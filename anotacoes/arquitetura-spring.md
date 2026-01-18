# Arquitetura Spring


##  Visão Geral da Arquitetura Spring

A arquitetura Spring é baseada em um **container central** responsável por criar, configurar e gerenciar os objetos da aplicação, chamados de **beans**.

O objetivo principal é:
- Reduzir acoplamento
- Facilitar manutenção
- Permitir aplicações escaláveis e testáveis

---

##  Spring Container

O **Spring Container** é o coração do framework.

Responsabilidades:
- Criar objetos (beans)
- Injetar dependências
- Gerenciar ciclo de vida dos componentes
- Ler configurações da aplicação

A aplicação **não controla diretamente** a criação dos objetos — isso é feito pelo container (IoC).

---

## Componentes da Aplicação

Os **componentes** são as classes que fazem parte da aplicação e são gerenciadas pelo Spring.

Exemplos:
- `@Component`
- `@Service`
- `@Repository`
- `@Controller`
- `@RestController`

Esses componentes:
- São detectados automaticamente
- Tornam-se **beans**
- Podem ser injetados em outras classes

---

## Application Context

O **ApplicationContext** é a implementação principal do Spring Container.

Ele representa:
- O ambiente de execução da aplicação
- O contexto onde os beans vivem
- As configurações carregadas

Principais funções:
- Gerenciamento de beans
- Resolução de dependências
- Publicação de eventos
- Integração com profiles e configurações

---

## 🔍 Component Scan

O **Component Scan** é o processo pelo qual o Spring procura classes anotadas para registrá-las como beans.

Funcionamento:
- O Spring escaneia pacotes definidos
- Identifica anotações como `@Component`, `@Service`, etc.
- Registra automaticamente no ApplicationContext

Por padrão:
- O Spring Boot escaneia a partir do pacote da classe `@SpringBootApplication`

É possível customizar:
```java
@ComponentScan(basePackages = "com.exemplo")
