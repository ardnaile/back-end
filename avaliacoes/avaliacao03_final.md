---
marp: true
theme: venson
author: Ramon Venson
title: Avaliação 03 - Projeto Final
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Avaliação 03 - Projeto Final
---

<!-- 
_class: lead
-->

# Avaliação 03 - Projeto Final

---

<!--
paginate: true
-->

## Metodologia

A avaliação `N3` consiste no design e codificação de um projeto de API RESTful para processamento de requisições de um cliente HTTP.

---

## Objetivos

* Avaliar a capacidade de desenvolvimento de um projeto completo;
* Desenvolver a capacidade de autonomia através da construção de um projeto com diferentes etapas do processo de desenvolvimento de software;
* Oferecer uma auto-avaliação individual prática para o estudante;

---

## Temas

Os projetos serão desenvolvidos dentro dos seguintes temas:

* `Mudanças Climáticas`: aplicações para visualização de dados ambientais, calculadora de emissões de carbono, monitoramento com sensores;
* `Saúde e Bem-estar`: Gerenciamento de medicamentos, mapeamento de atendimentos médicos, recomendações médicas;
* `Acesso à Educação`: *Math-system* para tutoria, repositórios educacionais, compartilhamento de dados públicos;
* `Agricultura e Segurança Alimentar`: Marktplace para agricultura familiar, monitoramento de plantações, mapeamento de desperdício alimentar;
* `Engajamento Comunitário`: *Match-system* para voluntários, gerenciamento de donativos, mapeamento de abrigos;

---

## Requisitos Obrigatórios:

<dual>

1. Desenvolvido utilizando o framework Spring;
1. Possui:
    1. entre três e sete `models`;
    1. dois ou três `services`;
    1. dois ou três `controllers`;
1. Foi disponibilizado em repositório git público e acessível;
1. Pode ser executado a partir de um container docker configurado;
1. Possui um `README.md` com toda a documentação necessária para executar e manipular a aplicação (exemplos de requisições);
1. Fornece configurações para execução rápida;
1. Possui código bem identado e projeto organizado;
1. Faz a paginação de entidades no `GET ALL`;
1. Valida e trata de erros do cliente;
1. Segue os princípios `REST`;

</dual>

---

Deverá conter ainda uma denominada: `/ajuda`, que deverá responder com conteúdo EXATAMENTE no seguinte formato:

````json
"estudantes": ["fulano", "beltrano"],
"projeto": "nome do projeto"
"tema": "tema do projeto"
````

---

## Requisitos Não-obrigatórios

* `Autenticação e Autorização`: a aplicação possui autorização e autenticação de uma ou mais rotas;
* `Testes Unitários`: a aplicação possui testes unitários para a maioria dos serviços;
* `Publicado`: o projeto foi publicado e está acessível e funcional ao professor;
* `CI/CD`: possui pipelines de CI/CD para testar, compilar e/ou implantar o software;
* `Pacotes Adicionais`: utiliza de dependências adicionais para aprimorar a aplicação ou o código.

---

## Nota Final

O projeto final sera avaliado com a nota de `0,0` a `10,0`, de acordo com os critérios de avaliação anteriores. Todos os critérios possuem o mesmo peso.

---

## Apresentação

O projeto deverá ser apresentado por **todos os componentes do grupo**, que deverão demonstrar o funcionamento da aplicação e conhecimento da implementação. A apresentação deverá ter **10-20 minutos** e deverá levar em consideração as três etapas:

* `Apresentação do Domínio`: apresentação das entidades e dos casos de uso utilizados no projeto. Deve-se deixar claro em quais casos o projeto será útil;

* `Funcionamento da Aplicação`: demonstração do projeto em funcionamento, desde a execução. Deve-se realizar pelo menos uma requisição de cada verbo do CRUD;

* `Arquitetura`: Deverá ser demonstrado a arquitetura da aplicação, compreendendo o código e a persistência de dados.

---

### Agenda de Apresentações

Semana|Datas
-|-
Semana 1 | 17 e 19 de Junho
Semana 2 | 24 e 26 de Junho

As apresentações poderão ser agendadas com o professor previamente. Apresentações não agendadas poderão ser distribuídas pelo professor entre os dias disponíveis.

---

## Entrega

A dupla deverá enviar a URL contendo o projeto completo, `README.md` com documentação e quaisquer outras ferramentas necessárias para a execução da aplicação.

As duplas devem realizar a entrega até a data da sua apresentação.

Todas as modificações no projeto deverão ser realizadas até o dia **26 de Junho de 2024**. **Não serão recebidos trabalhos ou apresentações após esse data**.

---

## Considerações Finais

* Projetos fora dos critérios relacionados pelo professor em sala de aula serão **rejeitados** automaticamente, incluindo:
  * Projetos postados fora do prazo;
  * Projetos sem relação com o enunciado da atividade;
  * Projetos que não podem ser executados corretamente;
* A **cópia comprovada** do projeto resulta na sua rejeição, o que inclui:
  * Projetos copiados de outros projetos;
  * Projetos não realizados pelo estudante;
  * Projetos com código fonte *consideravelmente* gerado por IA.
