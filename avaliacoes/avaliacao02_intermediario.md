---
marp: true
theme: venson
author: Ramon Venson
title: Avaliação 02 - Projeto Intermediário
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Avaliação 02 - Projeto Intermediário
---

<!-- 
_class: lead
-->

# Avaliação 02 - Projeto Intermediário

---

<!--
paginate: true
-->

## Metodologia

A avaliação `N2` consiste no design e codificação de um projeto web service contendo processamento de requisições de um cliente HTTP.

---

## Objetivos

* Avaliar a capacidade de desenvolvimento de um projeto completo;
* Desenvolver a capacidade de autonomia através da construção de um projeto com tema aberto ou semi-aberto;
* Oferecer uma auto-avaliação individual prática para o estudante;

---

## Requisitos:

O projeto deverá ser desenvolvido utilizando a plataforma Java e o framework Spring. Cada estudante deverá desenvolver um pequeno serviço capaz de fornecer rotas para requisições.

O serviço deverá possuir pelo menos um controller e um service. O controller deverá conter pelo menos uma rota GET para consultas (apenas leitura) e uma rota POST para enviar dados para processamento.

---

Deverá conter ainda uma denominada: `/ajuda`, que deverá responder com conteúdo EXATAMENTE no seguinte formato:

````json
"estudante": "seu nome",
"projeto": "nome do projeto"
````

---

Os projetos podem ser desenvolvidos dentro dos seguintes temas:

* Serviço de localização: (consulta distâncias, converte coordenadas...)
* Missões para um jogo MMORPG: (consulta quests, recebe dicas...)
* Marketplace (consulta aplicativos, avalia, pesquisa itens...)
* Placar de jogos (consulta jogos em andamento, marca jogos favoritos)
* Quiz (pesquisa perguntas, responde perguntas e recebe respostas...)
* Enquetes (cria enquetes, compartilha links, vota em enquetes...)
* Encurtador de Links (cria links compartilháveis, retorna endereço real...)
* Chat (consulta histórico do chat, envia mensagens...)
* Serviço de meteorologia (converte previsão do tempo para mensagens...)

---

Todos os projetos deverão ainda realizar a integração com serviços de API públicos e externos. Uma lista com diferentes APIs pode ser encontrada no [neste endereço](https://github.com/public-apis/public-apis).

Poderão utilizar ainda a integração com projetos de outros colegas. **Não inclua nenhum código dos projetos desenvolvidos por outros estudantes no seu projeto.**

---

## Critérios de Avaliação

* 
* **Funcionalidade**: o projeto serve seu propósito? Todas as rotas são bem definidas e implementadas corretamente?
* **Integração**: o projeto está integrado a uma API de terceiros, sendo capaz de reconhecer exceções (quando a API não estiver disponível).
* **Organização**: o projeto está bem organizado e contém um arquivo `README.md` explicando seu funcionamento? O código está bem organizado?
* **Criatividade e Inovação**: o projeto demonstra iniciativa e originalidade na sua implementação?

---

## Nota Final

O projeto final sera avaliado com a nota de `0,0` a `10,0`, de acordo com os critérios anteriores. Todos os critérios possuem o mesmo peso.

---

## Entrega

O estudante deverá realizar a postagem do endereço online de um repositório git até a data informada pelo professor em sala de aula. O repositório deve ser estar acessível ao professor.

Todas as modificações no projeto deverão ser realizadas até o dia **21 de Abril de 2024**.

---

## Considerações Finais

* Projetos fora dos critérios relacionados pelo professor em sala de aula serão **descontados** automaticamente, incluindo:
  * Projetos postados fora do prazo;
  * Projetos sem relação com o enunciado da atividade;
  * Projetos que não podem ser executados corretamente;
* A **cópia comprovada** do projeto resulta no desconto automático na nota final do estudante, o que inclui:
  * Projetos copiados de outros projetos;
  * Projetos não realizados pelo estudante;
  * Projetos com código fonte gerado por inteligência artificial.
