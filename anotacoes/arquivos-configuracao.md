
# Arquivo `application.properties` no Spring Boot

## Introdução

Nesta aula, foi discutido o arquivo **`application.properties`**, que é fundamental para a configuração de aplicações Spring Boot.  
Esse arquivo permite centralizar e organizar diversas configurações da aplicação, facilitando a manutenção e a personalização do comportamento do sistema.

---

## O que é o `application.properties`

O arquivo `application.properties` é utilizado para definir propriedades da aplicação, como:

- Configurações de banco de dados
- Configurações do servidor
- Personalização de mensagens e comportamentos do framework
- Ajustes de desempenho e segurança

Ele fica localizado, geralmente, em `src/main/resources`.

---

## Propriedades Comuns

### Configuração do Banco de Dados

Essas propriedades definem como a aplicação irá se conectar ao banco de dados:

- `spring.datasource.url`  
  Define a URL de conexão com o banco de dados.

- `spring.datasource.username`  
  Define o nome de usuário para acesso ao banco.

- `spring.datasource.password`  
  Define a senha para acesso ao banco.

---

### Configuração do Servidor

Essas propriedades controlam o comportamento do servidor embutido do Spring Boot:

- `server.port`  
  Define a porta na qual a aplicação será executada.

- `server.servlet.context-path`  
  Define o caminho de contexto da aplicação.

---

### Personalização de Mensagens e Erros

O Spring Boot permite personalizar o tratamento de erros e mensagens de exceção.

- `spring.mvc.throw-exception-if-no-handler-found=true`  
  Faz com que o Spring lance uma exceção quando não existir um handler para a requisição, facilitando a depuração de erros.

---

## Exemplo Prático

Abaixo está um exemplo de configuração no arquivo `application.properties` para conectar a aplicação a um banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/meubanco
spring.datasource.username=root
spring.datasource.password=senhaSecreta
server.port=8080
````

### Explicação do Exemplo

* A aplicação se conecta ao banco de dados **meubanco**, que está rodando localmente.
* O acesso ao banco é feito com o usuário **root** e a senha definida.
* A aplicação será executada na porta **8080**.


````md
## Leitura de Propriedades com YAML no Spring Boot

## Introdução

Nesta aula, abordamos a **leitura de propriedades em aplicações Spring Boot utilizando o formato YAML**, apresentando uma alternativa mais organizada e hierárquica em relação ao arquivo `application.properties`.

O uso do YAML facilita a leitura, manutenção e estruturação das configurações da aplicação, especialmente em projetos maiores.

---

## Arquivo `application.yaml`

O foco principal foi a substituição do arquivo `application.properties` pelo **`application.yaml`**, que permite organizar as configurações de forma mais clara, utilizando hierarquia e indentação.

### Exemplo básico de `application.yaml`

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/meubanco
    username: root
    password: senhaSecreta
````


## Métodos de Leitura de Propriedades


### Leitura com `Environment`

Um dos métodos mencionados foi o uso do objeto `Environment`, por meio do método `environment.getProperty`.

```java
@Autowired
private Environment environment;

public void exemplo() {
    String porta = environment.getProperty("server.port");
}
```

### Observação

Apesar de permitir acesso direto às propriedades e variáveis de ambiente, **essa não é a abordagem mais comum**, sendo mais utilizada em casos específicos.

---

## Uso da Anotação `@Value`

A anotação `@Value` foi apresentada como uma forma simples e direta de injetar valores de propriedades dentro das classes.

### Exemplo

```java
@Value("${server.port}")
private String serverPort;
```

Nesse exemplo, o valor definido no arquivo de configuração é injetado automaticamente na variável.


Um nome incorreto pode causar erros de injeção de dependência ou falhas na inicialização da aplicação.

---

## Propriedades Personalizadas

Criar **propriedades personalizadas** permite criar configurações específicas da aplicação.

É possível criar **classes que representem essas propriedades**, facilitando a organização e a gestão das configurações.

### Exemplo

```yaml
app:
  nome: MinhaAplicacao
  versao: 1.0.0
```

Essas propriedades podem ser mapeadas em classes específicas para melhorar a legibilidade e manutenção do código.

---
## Leitura de Propriedades com Classes no Spring Boot


Para acessar valores de propriedades de forma organizada em uma aplicação Spring Boot, é possível criar **classes de configuração** que encapsulam essas propriedades.  
Essa abordagem melhora a organização do código, facilita testes e centraliza as configurações da aplicação.

---

## Criação do Arquivo `application.yaml`

Primeiro, defina as propriedades no arquivo `application.yaml`, utilizando uma estrutura hierárquica.

### Exemplo

```yaml
app:
  config:
    variavel: "valorExemplo"
````

Nesse exemplo, foi criada uma propriedade personalizada chamada `variavel`, dentro do prefixo `app.config`.

---

## Definição da Classe de Configuração

Em seguida, cria-se uma classe responsável por mapear essas propriedades.
Utiliza-se a anotação `@ConfigurationProperties` para indicar ao Spring que a classe deve ser populada com os valores definidos no arquivo de configuração.

### Exemplo

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.config")
public class AppConfig {

    private String variavel;

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }
}
```

### Explicação

* `@Component`: registra a classe como um bean do Spring
* `@ConfigurationProperties(prefix = "app.config")`: define o prefixo das propriedades que serão mapeadas
* Os atributos da classe devem corresponder aos nomes das propriedades no YAML

---

## Usando a Classe de Configuração

Após criada, a classe de configuração pode ser injetada em qualquer componente gerenciado pelo Spring.

### Exemplo

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final AppConfig appConfig;

    @Autowired
    public MyService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void printVariavel() {
        System.out.println(appConfig.getVariavel());
    }
}
```

Nesse exemplo, o valor definido no `application.yaml` é acessado por meio do método `getVariavel()`.

---

## Vantagens dessa Abordagem

* Centraliza configurações em classes específicas
* Facilita manutenção e leitura do código
* Torna a aplicação mais organizada
* Melhora a testabilidade
* Evita uso excessivo de `@Value` espalhado pelo código

---
