# Injeção de Dependências no Spring Boot

## O que é Injeção de Dependências?

A **Injeção de Dependências (Dependency Injection – DI)** é um padrão de projeto utilizado no Spring Boot para reduzir o acoplamento entre classes.  
Em vez de uma classe criar manualmente suas dependências, o **Spring fornece automaticamente as instâncias necessárias** por meio do seu container de beans.

O Spring gerencia o ciclo de vida dos objetos, cuidando da criação, injeção e destruição, o que torna o código mais limpo e organizado.

---

## Inversão de Controle (IoC)

A **Inversão de Controle (IoC)** é o princípio fundamental por trás da injeção de dependências.  
Nesse modelo, o controle da criação e do gerenciamento dos objetos deixa de ser responsabilidade da aplicação e passa a ser do framework Spring.

### Benefícios da IoC

- Código mais organizado
- Menor acoplamento entre classes
- Melhor gerenciamento de memória
- Facilidade para manutenção e testes automatizados

---

## Por que usar Injeção de Dependências?

Sem a injeção de dependências, as classes precisam instanciar manualmente seus objetos, o que gera maior complexidade, acoplamento excessivo e dificuldade de manutenção.

Com a injeção de dependências, o Spring cuida da criação e da destruição dos objetos, tornando o código mais simples, limpo e fácil de evoluir.

---

## Tipos de Injeção de Dependências no Spring

O Spring oferece três principais formas de injeção de dependências:

1. Injeção via Construtor
2. Injeção via Atributo (`@Autowired`)
3. Injeção via Setter

---

## Injeção via Construtor (Recomendada)

A injeção via construtor é considerada a **melhor prática**, pois deixa explícito que a dependência é obrigatória e facilita a criação de testes automatizados.

### Exemplo

```java
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
```

### Quando usar

- Quando a dependência é obrigatória
- Para facilitar testes unitários
- Para garantir que o objeto seja criado em um estado válido

---

## Injeção via Atributo (`@Autowired`)

Nessa abordagem, o Spring injeta a dependência diretamente no atributo da classe.

### Exemplo

```java
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
}
```

### Quando usar

- Em exemplos simples ou códigos antigos
- Quando a simplicidade é prioridade

### Desvantagens

- Dificulta testes automatizados
- Esconde as dependências da classe
- Não permite o uso de atributos `final`


## Injeção via Setter

A dependência é injetada por meio de um método setter.

### Exemplo

```java
@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    public void setPedidoRepository(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
```

### Quando usar

- Quando a dependência não é obrigatória
- Quando a dependência pode ser alterada em tempo de execução

### Observações

- Método menos utilizado
- Pode gerar objetos parcialmente inicializados


## Comparação entre os Tipos de Injeção

| Tipo de Injeção | Recomendada | Dependência Obrigatória | Facilita Testes |
|-----------------|-------------|------------------------|-----------------|
| Construtor      | Sim         | Sim                    | Sim             |
| Atributo        | Não         | Não explícito          | Não             |
| Setter          | Depende     | Não                    | Parcialmente    |





