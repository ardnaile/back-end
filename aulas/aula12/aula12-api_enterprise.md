---
marp: true
theme: venson
author: Ramon Venson
title: Aula 12 - Enterprise Service
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Aula 12 - Enterprise Service
---

<!-- 
_class: lead
-->

# Aula 12 - Enterprise Service

---

<!--
paginate: true
class: normal
-->

## Enterprise Applications

> "Os aplicativos corporativos tratam da exibição, manipulação e armazenamento de grandes quantidades de dados muitas vezes complexos e do suporte ou automação de processos de negócios com esses dados." - Martin Fowler

- Multi-usuário e concorrência
- Alto padrão (Patterns e Arquitetura)
- Persistência, Validação, Integridade, Transações, Camadas...

---

![bg fit 60%](https://martinfowler.com/bliki/images/enterpriseApplication/sketch.png)

---

# RESTful Services

- Interface padronizada para troca de dados
- Baseado em **Recursos**
- Sistema de Camadas
- REST Design é aplicado nos controladores

---

![bg 70%](./assets/layers01.png)

> Arquitetura em
> camadas

---

> Alguns recursos são
> implementados em
> intercamadas

![bg 70%](./assets/layers02.png)

---

> Ciclo
> de Vida

![bg 60%](./assets/rest_api_timeline.png)

---

## Desenvolvimento

### External Layer

    - Validações
    - HTTP Codes
    - Controller REST

---

### Validações

![bg fit right](./assets/jakarta_validation.png)

Validações para entidades e records garantindo integridade dos dados.

> Bean Validation fornece uma forma comum de validação por meio de declaração de restrição e metadados para aplicativos Java

---

### HTTP Codes

![bg left](https://http.cat/images/206.jpg)

Definição correta dos códigos de estado do HTTP

> O código status 206 indica que a solicitação foi bem-sucedida e o corpo contém os intervalos de dados solicitados.

---

### Controler REST

![bg fit left](https://miro.medium.com/v2/resize:fit:640/1*lKMoDjlVtJfjxcF7uRKP1Q.png)

Definição de uma interface de comunicação padronizada e centrada em Recursos

> REST rapidamente se tornou o padrão a construção de serviços web na web porque eles são fáceis de construir e consumir

---

### Serviços
    - Data Transfer Objects
    - Mappers

### Domínio
    - Models/Entities

### Persitência
    - Repositories

---

### Data Transfer Objects

![bg fit right](https://farm4.static.flickr.com/3095/3120129852_0b88bba034_o.jpg)

Definir corretamente objetos para a transferência de dados entre cliente e servidor.

> "DTOs mantêm lógica fora do resto do código e também fornecem um ponto claro para alterar a serialização, caso deseje" - Martin Fowler

---

### Mappers

![bg fit right](https://martinfowler.com/eaaCatalog/mapperSketch.gif)

Mapeamento de objetos para objetos

> "Às vezes você precisa configurar comunicações entre dois subsistemas que ainda precisam permanecer ignorantes um do outro." - Martin Fowler

---

### Models

![bg fit left](https://static.packt-cdn.com/products/9781783284870/graphics/4870OS_02_10.jpg)

Modelagem dos objetos que serão centro da aplicação, contendo todos os dados necessários para o funcionamento

---

### Repositories

![bg fit right](https://media.licdn.com/dms/image/C4E12AQFPgq3VRNjVsA/article-cover_image-shrink_720_1280/0/1639975062782?e=1719446400&v=beta&t=Ntu0fI6Kc5j6AFjSvgdcuZQkaK5QiUCY9nYKRwW4I-w)

Interface da aplicação com persistência de dados

> O Repositorio fornece funcionalidade CRUD sofisticada para a classe de entidade que está sendo gerenciada.

---

### Segurança
    - Autenticação
    - Autorização
  
### Infraestrutura
    - Docker
    - Database (PostgreSQL)
    - Implantação (Deploy)
    - Testes Unitários *
    - Documentação *

---

### Autenticação

Processo de reconhecimento de um cliente/usuário identificado.

![bg fit left](./assets/authentication.png)

---

### Autorização

![bg fit right](./assets/authorization.png)

Processo de autorização de acesso à um usuário/cliente já autenticado

---

### Docker

![bg fit left](https://www.altexsoft.com/static/blog-post/2023/11/50d965c7-b468-4de6-ad45-d8c8cb385a02.jpg)

Encapsulamento de bibliotecas e ambientes em **containers padronizados**

> Com o Docker, os aplicativos e seus ambientes são virtualizados e isolados uns dos outros em um sistema operacional compartilhado do computador host.
---

### Database



![bg fit right](https://miro.medium.com/v2/resize:fit:1111/1*8XVpzNjkvuaq3JJjuhRmDA.png)

Gerenciadores de dados persistentes.

> Um banco de dados é uma coleção organizada de informações estruturadas, ou dados, armazenados em um computador.

---

### Deploy

![bg fit left](https://learn.microsoft.com/en-us/azure/spring-apps/enterprise/media/quickstart-deploy-web-app/diagram.png)

Disponibilização a um público (ambiente de produção). Requer a configuração de infraestruturas específicas.

---

### Testes Unitários

![bg fit right](https://b1410584.smushcdn.com/1410584/wp-content/uploads/2019/02/Run-with-spring-runner-class.png?lossy=0&strip=1&webp=1)

Teste de funções usando JUnit.

> Uma das principais vantagens da injeção de dependência é que ela deve facilitar o teste de unidade do seu código. Você pode usar objetos simulados em vez de dependências reais.

---

![bg fit 60%](https://cdn-media-1.freecodecamp.org/images/1*aH_ifsVI0cI5P5Guu1X1CQ.jpeg)

---

### Documentação

![bg fit left](https://static.imasters.com.br/wp-content/uploads/2019/05/22161337/sww.jpg)

A padronização da API ajuda na sua auto-documentação. Porém podemos utilizar de ferramentas para aprimorar a documentação dos detalhes da API