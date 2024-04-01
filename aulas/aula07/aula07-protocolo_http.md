---
marp: true
theme: venson
author: Ramon Venson
title: Aula 07 - Arquitetura da Web
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Aula 07 - Arquitetura da Web
---

<!-- 
_class: lead
-->

# Aula 07 - Arquitetura da Web

---

<!--
paginate: true
class: normal
-->

## Serviços Web
### O que é um web service?

![bg fit right:40%](https://miro.medium.com/max/1440/1*ZHcRJhG8wMQO_UQUsGXqww.png)

* Troca de dados entre aplicações
* Geralmente intermediário
* Usa procolos web (HTTP/HTTPS)
* Um tipo de Aplication Programming Interface (API)

---

### Exemplos de Web Services

* Ler dados de sensores e fornecer dados para um aplicativo mobile
* Verificar e fornecer autenticação para outras aplicações
* Enviar mensagens através de um BOT para mensageiros instantâneos
* Receber e armazenar fotos de um aplicativo nativo para desktop
* Fornecer uma interface para acesso e gerenciamento de dados (REST)

---

Atualmente podemos encontrar milhares de API disponíveis de maneira pública na Internet. Alguns exemplos:

* [Fotos de Cachorro](https://dog.ceo/api/breeds/image/random)
* [Fotos de Gato](https://aws.random.cat/meow)
* [Dados do Studio Gimbli](https://ghibliapi.herokuapp.com/)
* [Jogo de Cartas](http://deckofcardsapi.com/)
* [Tabela FIPE](https://deividfortuna.github.io/fipe/)
* Uma [outra lista](https://github.com/public-apis/public-apis) completa

---

## Protocolos

* `TCP` e `IP`, responsáveis pelo endereçamento e transmissão de pacotes;
* `DNS`, responsável pela tradução de endereços para nomes de domínio;
* `HTTP` e `HTTPS`, responsáveis pelo tráfego de mensagens entre aplicações;

---

![bg fit 60%](https://media.prod.mdn.mozit.cloud/attachments/2016/08/09/13673/6d339b54f6873b97728986a2d9d930dd/HTTP%20%26%20layers.png)

---

![bg fit 70%](https://docstore.mik.ua/orelly/networking/firewall/figs/fire0602.gif)

---

### TCP e IP

Os protocolos **TPC** e **IP** são geralmente utilizados como base para todas as trocas de dados em web services

* **TPC**: Garante integridade, ordem e entrega final dos pacotes
* **IP**: roteamento dos pacotes através do endereço IP

---

### DNS

Domain Name System, responsável pela tradução dos nomes de domínio (ex.: exemplo.com.br) para um endereço IP (ex.: 20.30.2.1)

![bg fit right:60%](https://www.cloudflare.com/img/learning/dns/what-is-dns/dns-lookup-diagram.png)

---

### HTTP

![bg fit right:50%](https://documentation.help/DogeTool-HTTP-Requests-vt/http_requestmessageexample.png)

* Camada de Aplicação
* Requisição/Resposta
* Protocolo sem estado (stateless)
* Porta 80

---

#### Exemplo de Requisição HTTP

* Método + Caminho + Versão + Cabeçalhos + Corpo

````
POST /login HTTP/1.1
Connection: Keep-Alive
{user: "teste", password: "123456"}
````

> Repare que não é necessário especificar o servidor (host) pois é a camada de rede/transporte o responsável por realizar a conexão

---

#### Exemplo de Resposta HTTP

* Versão + Status + Cabeçalhos + Corpo

````
HTTP/1.1 200 OK
Host: example.com
Content-Length: 73
Date: Fri, 06 Aug 2030 01:31:51 GMT
<html><head><title>Introducao<title></head><body>Olá Mundo!</body></html>
````

---

#### Tipos de Conteúdo

O formato do corpo da mensagem geralmente é identificado usando um cabeçalho chamado `Content-Type`. Exemplos:
* Texto plano genérico (`text/plain`)
* Áudio (`audio/mpeg`), Vídeo (`video/mp4`) e Imagem (`image/png`)
* Binário (`application/octet-stream`)
* HTML (`text/html`)
* Formulário (`multipart/form-data`)
* JSON (`application/json`)

---

#### Estabelecendo uma conexão

![bg fit right:50%](https://www.testingsyndicate.com/wp-content/uploads/2018/09/HTTP-Connection-Lifecycle-2.png)

Sempre que uma requisição HTTP é feita, é preciso que as camadas de rede/transporte realizem a conexão com o servidor antes de realizar qualquer requisição.

Conexões do tipo ***Keep-Alive*** podem ser utilizadas para múltiplas requisições.

---

### Comparação entre versões HTTP

![](https://images.ctfassets.net/ee3ypdtck0rk/4du4aqnKuOLU4YbbHWYSfv/c88d774f278090e6ef3a5435b46bbfea/Screen_Shot_2021-01-28_at_6.54.47.png)

---

* `1.0`: 1996
  * Pouco/Nenhum suporte a compressão
  * Apenas `GET`, `HEAD` e `POST`
* `1.1` (mais utilizado): 1997
  * Novos Métodos e Códigos de Resposta
  * Keep-Alive
  * Compressão aprimorada do corpo da mensagem

---

* `2.0`: 2015
  * Compressão do cabeçalho
  * Resposta e Requisições Multiplexada na camada de aplicação
    * Permite "enfileirar" requisições e respostas
    * Pacotes perdidos na camada de rede/transporte ainda bloqueiam as requisições
  * Server-Push (servidor envia respostas sem necessidade de requisições)

---

* `3.0` (draft): 2018
  * Troca do TCP+TLS para UDP+QUIC
  * Multiplexação não bloqueante na camada de transporte
    * Pacotes perdidos na camada de rede/transporte não bloqueiam outros pacotes

---

### HTTPS

* Extensão do procolo HTTP
* Utiliza uma camada de segurança chamada *Transport Layer Security* (TLS)
* Negociação da criptografia usando chaves públicas
* Iniciada durante a fase de conexão
* Porta 443

> O TLS é uma versão mais recente do *Secure Sockets Layer* (SSL), termo ainda usado para descrever a mesma camada.

---

## Construindo um Web Service

* Spring Framework
* Persistência de Dados
  * NOSQL (MongoDB)
  * SQL (PostgreSQL)
* Formato de Troca de Dados
  * JSON
* Arquitetura REST

---

## O que aprendemos nessa aula?

* O que são serviços web e exemplos
* Quais os protocolos mais utilizados por aplicações web
* Como são realizadas as requisições HTTP
* Quais ferramentas vamos utilizar para construir aplicações web