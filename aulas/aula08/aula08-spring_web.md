---
marp: true
theme: venson
author: Ramon Venson
title: Aula 08 - Spring Web
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Aula 08 - Spring Web
---

<!-- 
_class: lead
-->

# Aula 08 - Spring Web

---

<!--
paginate: true
class: normal
-->

## Spring Web

![bg fit left:30%](https://gauthier-cassany.com/images/post/spring-boot-hibernate-search/thumbnail.png)


- Parte integrante do Spring Framework
- Recursos para lidar com solicitações HTTP e gerenciar controladores.
- Pode manipular também visualizações.

---

## Spring Boot e Spring Initializr

![bg fit right:30%](https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo.png)

- O Spring Boot é um framework opinativo para construir aplicações Spring em produção com configuração mínima.
- O Spring Initializr é uma ferramenta baseada na web para gerar projetos Spring Boot com dependências e configurações personalizadas.
- Ele simplifica o processo de inicialização de um projeto Spring Boot, fornecendo uma interface amigável para selecionar dependências e gerar modelos de projeto.

---

## Servidor de Aplicação

![bg fit left:30%](https://upload.wikimedia.org/wikipedia/commons/f/fe/Apache_Tomcat_logo.svg)

- Ambiente de execução para aplicações Web.
- Gerencia solicitações e coloca as aplicações em contato com a camada TCP/IP.
- Por padrão, o Spring Boot usa o Tomcat, um servidor de aplicação de código aberto e leve.
---

## Como criar a primeira rota para minha aplicação Spring Web

1. Crie um novo projeto Spring Boot usando o Spring Initializr.
1. Defina uma classe de controlador com a anotação `@RestController`.
1. Defina um método de manipulador dentro da classe do controlador para lidar com solicitações HTTP.
1. Use `@GetMapping("/")` ou outras anotações de mapeamento para especificar o mapeamento de URL para o método de manipulador.
1. Execute a aplicação e acesse a rota definida em um navegador da web.

---

### Criando um novo projeto

![bg fit right:60%](https://miro.medium.com/v2/resize:fit:1400/1*wyKUwk8rF69HBU65nHChOw.png)

* Acesse o site [Spring Initialzr](https://start.spring.io)
* Configuração padrão:
  * Projeto: Maven
  * Spring Boot: 3+
  * Packaging: Jar
  * Java: 17

---

### Rodando e configurando porta de rede


* Descompacte a pasta `*.zip` baixada e abra o projeto
* Adicione a seguinte linha ao arquivo `applications.properties` para mudar a porta da aplicação

```yml
server.port = 8080 //8080 é a porta padrão
```

---

### Criando um Controller

Crie uma nova classe e adicione um método para criar um novo mapeamento de rota.

`HelloWorldController.java`
````java
@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String olaMundo() {
        return "Olá mundo";
    }
}
````

Não esqueça das anotações @RestController e @GetMapping("/"). Você pode substituir o `/` por qualquer outro nome.

---

### Acessando a rota

![bg fit right](https://www.tutorialspoint.com/expressjs/images/hello_world.jpg)

Após rodar sua aplicação e utilizando um navegador ou qualquer outro cliente HTTP, realize a requisição para o endereço:

```
http://localhost:8080/
```

Lembre-se de substituir a porta `8080` caso tenha configurado outra e adicionar a rota definida no `@GetMapping("/")`

---

## Criando um Service

O Controller geralmente é responsável apenas por receber e validar requisições, assim como enviar repostas. Para padronizar nossa rota, vamos adicionar um novo service para transferir as responsabilidades de regra de negócios para a sua devida camada:

`HelloWorldService.java`
```java
@Service
public class HelloWorldService {
    public String gerarOlaMundo() {
        return "Ola, mundo!"
    }
}
```

---

Agora vamos refatorar o nosso `HelloWorldController.java`:

````java
@RestController
public class HelloWorldController {
  @Autowired
  private HelloWorldService helloWorldService;

  @GetMapping("/")
  public String olaMundo() {
      return helloWorldService.gerarOlaMundo();
  }
}
````

Não esqueça de criar um atributo na classe controller e usar a anotação `@Autowired` para que o Spring gerencie automaticamente essa dependência.

---

## Explorando requisições

O Spring Web empacota e gerencia os dados de cada uma das requisições que nosso web service recebe. Para acessar alguns destes dados, podemos utilizar:

* `@RequestParam` para ler parâmetros de query
* `@RequestBody` para ler o corpo de uma requisição
* `@RequestHeader` para ler cabeçalhos de uma requisicao
* `@PathVariable` para ler variáveis de caminho da requisição

---

### `@RequestParam`

Essa anotação extrai o conteúdo de uma query string da URL, como por exemplo: `https://localhost:8080/?nome=Faustao`

````java
@GetMapping("/")
public String olaMundo(@RequestParam nome) {
  return helloWorldService.gerarOlaMundo() + nome; // Olá, Mundo! Faustao
}
````

---

### `@RequestBody`

Essa anotação extrai o conteúdo do corpo da requisição.

````java
@GetMapping("/")
public String olaMundo(@RequestBody nome) {
  return helloWorldService.gerarOlaMundo() + nome;
}
````

---

### `@RequestHeaders`

Essa anotação extrai o conteúdo dos cabeçalhos da requisição.

````java
@GetMapping("/")
public String olaMundo(@RequestHeaders nome) {
  return helloWorldService.gerarOlaMundo() + nome;
}
````

---

### `@PathVariable`

Essa anotação extrai o conteúdo de uma variável definida no caminho da requisição, como por exemplo: `https://localhost:8080/galvao`

````java
@GetMapping("/{nome}")
public String olaMundo(@PathVariable("nome") nome) {
  return helloWorldService.gerarOlaMundo() + nome; // Ola, Mundo! Galvao
}
````

---

## Lendo variáveis de ambiente

Podemos fazer com que o Spring injete automaticamente variáveis de ambiente dentro de variáveis do nosso programa. Para isso usamos a anotação `@Value()`.

````java
@RestController
public class HelloWorldController {
  @Value("${app.nome}")
  private String nome;

  @GetMapping("/")
  public String helloWorld() {
      return helloWorldService.gerarOlaMundo() + nome; // Ola, Mundo! MeuApp
  }
}
````

---

Podemos usar o arquivo `application.properties` para definir essas variáveis de ambiente num arquivo, automaticamente:

```yml
spring.application.name=demo
server.port = 8000
app.nome = "MeuApp"
```

---

## O que aprendemos hoje

- O Spring Web é uma parte do Spring Framework para construção de aplicações web.
- O Spring Boot e o Spring Initializr simplificam o processo de criação de projetos Spring Boot.
- Aprendemos como criar a primeira rota para uma aplicação Spring Web usando controladores e mapeamentos de solicitação.
