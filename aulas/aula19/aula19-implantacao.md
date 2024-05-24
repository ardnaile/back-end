---
marp: true
theme: venson
author: Ramon Venson
title: Aula 19 - Implantação e Containers
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Aula 19 - Implantação e Containers
---

<!-- 
_class: lead
-->

# Aula 19 - Implantação e Containers

---

<!--
paginate: true
class: normal
-->

## Maven CLI

O comando `mvn` pode ser usado para rodar a ferramenta maven e interagir com o projeto. Um `wrapper` é geralmente disponibilizado na pasta de projetos criados pela IDE para que seja possível rodar um projeto sem o Maven instalado.

Esse comando permite rodar perfils de execução específicos, como `test` para rodar testes de aplicação e `compile` para compilação.

Plugins para o Maven como o do projeto `spring-boot` permitem a definição de perfis de execução alternativos, como o `mvn spring-boot:run` para rodar uma aplicação `spring-boot`.

---

### Lista de Comandos

|comando|descrição|
|-|-|
|`mvn install`|Instala dependências especificadas no arquivo `pom.xml`|
|`mvn test`|Roda todos os casos de teste declarados no projeto|
|`mvn compile`|Compila o código fonte do projeto|
|`mvn clean`|Remove todos os arquivos compilados (pasta `target`)|
|`mvn package`|Cria um pacote WAR ou JAR para distribuição|
|`mvn spring-boot:run`|Roda um projeto spring-boot|

---

## JAR

O comando `java -jar meuapp.jar` pode ser utilizado para rodar uma aplicação distribuível no formato `jar`.

O `jar` é um tipo de arquivo compactado executável usado para distribuição das classes java e outros recursos de um projeto. Esse tipo de pacote também pode ser "ofuscado" para que o conteúdo não seja (facilmente) identificável.

---

## Docker

![bg fit right:40%](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnqOUgRCcYSk0x0MaRGwBmsvfirI04lsIggcW19gZZog&s)

O *Docker* é um padrão de encapsulamento de bibliotecas e ambientes em **containers padronizados**

Isso permite que ambientes de execução sejam compartilhados sem diferenças e com o mínimo de esforço.

---

## Componentes do Docker

![bg fit left:40%](https://k21academy.com/wp-content/uploads/2020/05/2020-05-12-16_36_49-PowerPoint-Slide-Show-Azure_AZ104_M01_Compute_ed1-1.png)

O Docker pode ser dividido em diferentes componentes:

* Imagem
* Container
* Volume
* Rede

---

### Imagens

Uma imagem Docker define o ambiente e o conjunto de instruções que serão executadas em um **container**. 

Podemos consultar as imagens disponíveis localmente no Docker usando o comando:

````sh
docker image ls
````

Para instalar uma imagem vinda do repositório [hub.docker.com](https://hub.docker.com):

````sh
docker pull docker # imagem oficial do docker
````

---

### Containers

Containers são instâncias de ambientes e aplicações. **Containers não são máquinas virtuais**, visto que estas requerem um sistema operacional completo.

Diferentes containers podem rodar simultaneamente na mesma máquina hospedeira (*host*) de forma completamente isolada ou compartilhando recursos.

Podemos consultar os containers rodando localmente:

````sh
docker container ps
````

Para rodar um container a partir de uma imagem:

````sh
docker run docker:latest
````

---

![bg 80%](https://www.netapp.com/media/Screen-Shot-2018-03-20-at-9.24.09-AM_tcm19-56643.png)

---

### Volumes

Um container não possui persistência dos dados após o fim do seu ciclo de vida. O uso de volumes implementa um sistema de arquivos virtual para os containers armazenarem e compartilharem dados entre si e a máquina hospedeira.


### Redes

Outro recurso importante e poderoso do docker é a possibilidade de criar redes virtuais, que interagem com o hospedeiro e entre os containers. Isso permite que a comunicação de rede de diferentes containers seja encapsulada em uma estrutura mais segura.

---

### Dockerfile

O `Dockerfile` é um arquivo de texto usado para definir a criação de uma imagem. Ele permite partir de uma imagem previamente criada, determinando novas características e pacotes para a imagem resultante:

````yml
FROM debian:latest
RUN apt-get update && apt-get upgrade -y
RUN apt-get install nginx -y
CMD ["nginx", "-g", "daemon off;"]
````

---

### CI/CD

`Continuous Integration` (CI) funciona enviando pequenos pedaços de código para a base de código do seu aplicativo hospedada em um repositório Git e, a cada envio, execute um pipeline de scripts para criar, testar e validar as alterações de código antes de mesclá-las na ramificação principal.

`Continuous Delivery` (CD) consiste em um passo adicional da CI, implantando seu aplicativo na produção a cada push na ramificação padrão do repositório.

---

![bg fit](https://miro.medium.com/v2/resize:fit:942/1*3stkQyMCIZHjDII0dUOaJw.png)

---

O CI/CD do GitLab é configurado por um arquivo chamado `.gitlab-ci.yml`, colocado na raiz do repositório. Os scripts definidos neste arquivo são executados pelo GitLab Runner.

Os Runners podem ser configurados em ambiente privado (mesmo que o repositório esteja hospedado no [GitLab](https://gitlab.com). O GitLab também disponibiliza *Shared Runners* que são compartilhados entre os projetos hospedados na plataforma.

---

### Exemplo de `.gitlab-ci.yml`

````yaml
image: node:8.10.0
cache:
  paths:
    - node_modules/
stages:
  - deploy_production
production:
  image: ruby:latest
  only:
    - master
  stage: deploy_production
  script:
    - apt-get update -qy
    - apt-get install -y ruby-dev
    - gem install dpl
    - dpl --provider=heroku --app=$HEROKU_APP_NAME --api-key=$HEROKU_API_KEY
````

---

### Configurando o `.gitlab-ci.yml`

O arquivo ``.gitlab-ci.yml`` deve ser adicionado na pasta raiz do projeto para que o Gitlab possa reconhecer as configurações e executar os *runners*.

É nesse arquivo que vamos especificar os **Stages**, as fases do CI que geralmente serão executadas depois de um commit no repositório.

Cada **Stage** possui diferentes **Jobs**, que definem uma tarefa rodada pelos *runners*.

[Sintaxe do .gitlab-ci.yml](https://docs.gitlab.com/ee/ci/yaml/)

---

#### Exemplo

A cada commit adicionado em nosso repositório, vamos garantir que o software continua passando em todos os testes e ainda é possível ser compilado. Dessa forma podemos definir inicialmente dois **Stages**: `test` e `build`

````yml
stages:
  - test
  - build
````

---

No mesmo arquivo vamos definir um job que fará parte do primeiro stage, e fará os testes unitários no nosso projeto:

````yml
testes-unitarios:
  stage: test
  image: maven:3.8.3-openjdk-17
  script:
    - mvn clean test
````

O parâmetro `image` define uma imagem docker que será utilizada para rodar o *job* que estamos chamando de `testes-unitarios`.

O parâmetro `script` define uma lista de comandos que serão executados pelo *runner*. Nesse caso, vamos limpar e testar o projeto.

---

Vamos adicionar também um *job* que fará a compilação da nossa aplicação:

````yml
pacote-jar:
  stage: build
  image: maven:3.8.3-openjdk-17
  script:
    - mvn clean package -DskipTests
  artifacts:
    paths:
      - ./target/*.jar
    when: always
    expire_in: 1 hrs
  only:
    - master
````

Aqui temos um novo parâmetro: o `artifacts` salva o arquivo `.jar` gerado para uso em outros *runners* e também pode ser acessado na página do projeto.

---

Os parâmetros `when` e `expire_in` definem que esse artefato será armazenado sempre, mesmo em caso de insucesso, por pelo menos uma hora.

Repare temos ainda um parâmetro chamado `only`, que serve para que este *job* seja executado apenas quando o *commit* for relacionado ao *branch* `master`

---

### Executando o CICD

![bg fit left](https://docs.gitlab.com/ee/ci/pipelines/img/pipeline_dependency_view_v16_11.png)

Após criar o arquivo `.gitlab-ci.yml` na raiz do projeto, vamos commitar e enviar as alterações para a página do projeto no Gitlab. Dessa forma, a pipeline deve ser inicializada imediatamente (ou assim que os *runners* estiverem disponíveis).

---

## Containerizando uma Aplicação

Para criar um container que rode uma aplicação, primeiro iremos criar uma imagem docker para contê-la, incluindo todos os pacotes e dependências necessárias para o seu funcionamento. Para isso vamos criar um arquivo `Dockerfile` **na pasta raiz** da aplicação:

````yml
FROM openjdk:17-alpine # imagem base
COPY /target/*.jar app.jar # copia apenas o jar
EXPOSE 8080 # documenta o uso da porta 8080
ENTRYPOINT ["java","-jar","/app.jar"] # comando ao iniciar o container
````

---

### Criando uma imagem nova

Para criar uma imagem nova, na raiz da aplicação, onde está definido o `Dockerfile`, vamos rodar o seguinte comando:

````sh
docker build -t meuapp:latest .
````

Verifique se a imagem foi gerada corretamente:

````sh
docker image ls
````

E para rodar a imagem recém criada, use:

````sh
docker run meuapp:latest
````

---

## Gitlab Registry

O Gitlab Registry é uma funcionalidade do Gitlab que permite atribuir imagens à um projeto. Desde que essa funcionalidade esteja habilitada no projeto, podemos realizar usar o terminal para realizar o login nesse repositório.

O login pode ser realizado com usuário e senha:

````
docker login -u meu_usuario_gitlab -p minha_senha registry.gitlab.com
````


No entanto, é interessante criar um Token de acesso para realizar essa operação.

---

### Criando um Token

Para criar um **Token de Autenticação**, vá até as configurações do seu projeto e acesse a opção `Tokens de Acesso` > `Adicionar novo token`. Não esqueça de marcar os escopos relacionados ao envio e leitura de registros: `read_registry` e `write_registry`.

Com o token em mãos, utilize ele ao invés da sua senha:

````
docker login -u meu_usuario_gitlab -p meu_token registry.gitlab.com
````

---

### CICD e Registry

É possível configurar um **Job** para registrar imagens automaticamente no Registry do seu projeto, para isso, adicione a seguinte tarefa no seu `.gitlab-ci.yml`.

Utilizando *Runners* é possível utilizar variáveis de ambiente padronizadas do Gitlab para autenticar e acessar a URL do Registry do seu projeto automaticamente.

---

Segue o exemplo:

````yml
deploy-gitlab:
  image: docker
  stage: deploy
  services:
    - docker:dind
  before_script:
    - docker login -u $CI_REGISTRY_USER -p $CI_JOB_TOKEN $CI_REGISTRY
  script:
    - docker build -t $CI_REGISTRY_IMAGE .
    - docker push $CI_REGISTRY_IMAGE
  dependencies:
    - build
  only:
    - master
````

---

## Google Run

---

## Docker Compose

O Docker Compose é uma ferramenta do Docker (antigamente plugin) que permite definir e rodar múltiplos containers, facilitando a execução de ambientes complexos e permitindo uma criação mais fácil de redes e volumes.

Para usar o Docker Compose, podemos definir na raiz do projeto um arquivo de texto chamado `docker-compose.yml` (esse não é mais um padrão).

---

<dual>

````yml
services:

  postgres:
    image: postgres
    ports:
      - "5432:5432"
    networks:
      - app-network

  meu-app:
    image: meu-app:latest
    container_name: meu-app
    volume: ./data:meu-app
    networks:
      - app-network
    build:
      dockerfile: ./Dockerfile
    ports:
      - "3001:3001"
    depends_on:
      - postgres
      
````
````yml
networks: 
  app-network:
    driver: nat

volumes:
  meu-app:
````
Essa configuração (exemplo) permite abrir dois containers, um para o banco de dados e outro para a aplicação, conectando-os em uma rede virtual. Para iniciar a configuração, use:

````sh
docker compose up -D
````

</dual>

---

## O que aprendemos hoje

* 
