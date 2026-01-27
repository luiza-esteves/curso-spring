
# Inicialização Lazy de Beans no Spring Boot

## Introdução

**Inicialização lazy (preguiçosa)** dos beans no Spring Boot, uma técnica fundamental para otimizar a arquitetura e o desempenho de aplicações Java.

A inicialização lazy permite que os beans sejam criados **apenas quando realmente necessários**, em vez de serem instanciados durante a inicialização da aplicação.

---

## O que é Inicialização Lazy

A inicialização lazy define que a instância de um bean **não será criada no startup da aplicação**, mas somente no momento em que for utilizada.

A palavra *lazy* indica esse comportamento adiado, ajudando a economizar recursos e reduzir o tempo de inicialização da aplicação.

---

## Implementação com `@Lazy`

Para habilitar a inicialização lazy em um bean específico, utiliza-se a anotação `@Lazy`.

### Características

- Quando anotado com `@Lazy`, o bean só é instanciado quando for acessado  
- Sem a anotação, o Spring instancia os beans automaticamente no início da aplicação  
- O valor padrão da anotação é `true`  

### Exemplo

```java
@Service
@Lazy
public class RelatorioService {
}
````

Nesse exemplo, o `RelatorioService` será criado apenas quando algum componente da aplicação precisar utilizá-lo.

---

## Configuração Global de Lazy Initialization

É possível configurar a inicialização lazy **para todos os beans do projeto**.

### Via `application.properties`

```properties
spring.main.lazy-initialization=true
```

### Comportamento

* Todos os beans passam a ser lazy por padrão
* Beans só são criados quando requisitados
* Pode reduzir significativamente o tempo de startup

---

## Quando Utilizar Inicialização Lazy

* Serviços utilizados raramente
* Processamento pesado ou custoso
* Funcionalidades acessadas sob demanda
* Aplicações grandes com muitos beans

---

## Cuidados ao Usar Lazy Initialization

Apesar dos benefícios, é importante ter atenção ao usar inicialização lazy.

### Pontos de atenção

* Erros podem ocorrer em tempo de execução
* Beans não inicializados podem falhar quando acessados
* Dificulta a identificação de erros no startup

Por isso, recomenda-se usar a inicialização lazy **de forma seletiva**, apenas onde realmente faz sentido.

---

## Exemplo Prático

Um serviço responsável por gerar relatórios pode ser configurado como lazy, pois só será utilizado quando o usuário solicitar a geração de um relatório.

Dessa forma, o bean não é criado durante a inicialização da aplicação, economizando recursos e melhorando o desempenho inicial.

---