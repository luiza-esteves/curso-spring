# Escopos de Beans no Spring Framework

## Introdução

O escopo define **quanto tempo um bean vive** e **em que contexto ele será compartilhado** dentro da aplicação.

O Spring oferece diferentes tipos de escopos para atender às necessidades de aplicações simples e também aplicações web mais complexas.

## Escopo Singleton

O **Singleton** é o escopo padrão no Spring. Nesse escopo, **uma única instância do bean é criada** e compartilhada por toda a aplicação.

### Características

- Apenas uma instância do bean existe no container
- Compartilhado entre todos os usuários
- Mais econômico em termos de recursos

### Exemplo de uso

Um bean responsável por gerenciar configurações globais da aplicação.

```java
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ConfiguracaoService {
}
```

## Escopo Request

O escopo **Request** é específico para aplicações web. Um novo bean é criado **para cada requisição HTTP** e destruído ao final dela.

### Características

- Um bean por requisição
- Não compartilha dados entre requisições
- Ideal para dados temporários

### Exemplo de uso

Um bean responsável por processar uma requisição HTTP.

```java
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestService {
}
```

## Escopo Session

O escopo **Session** mantém o bean ativo durante toda a **sessão do usuário**.

### Características

- Um bean por sessão
- Dados persistem enquanto a sessão existir
- Usado para informações do usuário

### Exemplo de uso

Um bean que armazena dados de login do usuário.

```java
@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UsuarioSession {
}
```

## Escopo Application

O escopo **Application** mantém o bean ativo durante todo o tempo de execução da aplicação e é compartilhado entre todos os usuários.

### Características

- Um bean para toda a aplicação
- Compartilhado entre todas as sessões
- Similar ao Singleton em aplicações web

### Exemplo de uso

Um bean que mantém contadores globais de acesso.

```java
@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class ContadorAcessos {
}
```

## Escopo Prototype

O escopo **Prototype** cria **uma nova instância do bean a cada solicitação** ao container.

### Características

- Uma nova instância a cada injeção
- Não é gerenciado completamente pelo Spring após a criação
- Ideal para objetos com estado próprio

### Exemplo de uso

Um serviço que gera relatórios personalizados.

```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RelatorioService {
}
```

## Boas Práticas

- Usar **constantes** para definir os escopos, evitando erros de digitação
- Escolher o escopo de acordo com o ciclo de vida necessário do bean
- Evitar armazenar estado em beans Singleton
