---
marp: true
theme: venson
author: Ramon Venson
title: Aula 02 - Ambiente de Trabalho
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Aula 02 - Ambiente de Trabalho
---

<!-- 
_class: lead
-->

# Aula 02 - Ambiente de Trabalho

---

<!--
paginate: true 
class: normal
-->

## Ferramentas de Trabalho

---

### Java Development Kit

![bg fit right:50%](https://media.geeksforgeeks.org/wp-content/uploads/20210218150010/JDK.png)

* JDK 21 (LTS)
* [JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://jdk.java.net/21/)

---

### IntelliJ IDEA

![bg fit right:40%](https://www.jetbrains.com/idea/download/screenshots/download.png)

* Integrated Development Environment (IDE)
* [Community Edition](https://www.jetbrains.com/idea/download)

---

### git

![bg fit right:40%](https://git-scm.com/images/branching-illustration@2x.png)

* Ferramenta de Controle de Versão
* Git Bash
* [Lastest Release](https://git-scm.com/downloads)

---

### Docker

![bg fit right:40%](https://www.docker.com/wp-content/uploads/2023/08/docker-desktop-hero-v2.svg)

* Conteinerzização
* Compose para multi-containers
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)

> *docker-compose* precisa ser instalado para versões mais antigas do docker

---

### Spring Framwork

![bg fit right:40%](https://4.bp.blogspot.com/-9kYSwCDRbms/W-qSUvwnFWI/AAAAAAAAEsE/j4EeFEPQHBc-QpxMV9l3gQAaLAuG2WhTgCLcBGAs/s1600/spring-framework.png)

* Inversão de Controle (IoC)
* Modular
  * Spring Boot
  * Spring Web
  * Spring Data
* [Spring](https://spring.io/)

---

![bg fit](https://i.pinimg.com/originals/eb/95/59/eb9559ad504e7ede8016114b579e334d.png)

---

## Praticando

## Criando um Hello World

````java
public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Olá Mundo!");
    }
}
````

---

## Realizando requisições HTTP

````java
public class Main {
    public static void main(String[] args) throws Exception{
        String uri = "https://gitlab.com/snippets/1896187/raw";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
````

---

## Gerando vetores a partir do texto

````java
String [] linhas = texto.split("\n");
````

---

## Percorrendo vetores

````java
String[] linhas = {"Içara", "Maracajá", "Araranguá", "Cocal do Sul"};
for (String l : linhas) {
  System.out.println(l);
}
````

---

## Substituindo caracteres de uma String

````java
String texto = "Amigos";
texto.replace("o", "e");
````

---

## Números aleatórios

Criando número aleatório:

````java
double aleatorio = Math.random(); // 0.0 até 1.0 (não-inclusivo)
double numeroMultiplicado = aleatorio * 100; // 0.0 até 100.00 (não-inclusivo)
int numeroTruncado = (int) Math.floor(numeroMultiplicado) // 0 até 99;
````

Gerando indice aleatório:

````java
String[] jogos = {"cs2", "lol", "fifa"}
int indiceAleatorio = Math.floor(Math.random() * jogos.length);
String jogoAleatorio = jogos[indiceAleatorio];
````

---

## O que aprendemos nessa aula?

* Instalar as ferramentas que serão utilizadas na disciplina;
* Organizar o Ambiente de Trabalho;
* Criar uma aplicação simples em java usando requisições HTTP;
* Introdução à manipulação de strings e vetores;