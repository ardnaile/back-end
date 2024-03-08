---
marp: true
theme: venson
author: Ramon Venson
title: Extra 01 - Criando Repositório Remoto
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Extra 01 - Criando Repositório Remoto
---

<!-- 
_class: lead
-->

# Extra 01 - Criando Repositório Remoto

---

<!--
paginate: true
class: normal
-->

## tl;dr

* Criar conta no [GitLab](https://gitlab.com);
* Criar a página do repositório remoto no GitLab (sem inicializar);
* Organizar a pasta do seu projeto e inicializar o repositório local Git (`git init`);
* Realizar o primeiro commit (`git add .` e `git commit -m "mensagem"`);
* Adicionar o endereço do repositório remoto (`git remote add origin [URL]`);
* Fazer o envio das alterações locais (`git push origin master`).

> Não esqueça de observar o nome do branch inicial (geralmente master ou main)

---

## Repositórios de Código

Da necessidade de compartilhar código-fonte e garantir a disponibilidade do código na nuvem surgiram vários gerenciadores de repositório de código-fonte, como é o caso do [GitLab](https://gitlab.com).

Este é o passo-a-passo para a criação de um repositório online e a sincronização com o repositório da máquina local.

---

## 

![bg fit right:50%](https://www.git-tower.com/learn/media/pages/git/ebook/en/command-line/remote-repositories/introduction/ca91d7d832-1697824976/basic-remote-workflow.png)

* Um repositório local é definido como um repositório particular de cada programador.
* Um repositório remoto é o repositório usado para sincronizar repositórios locais.

Neste caso, usaremos o [GitLab](https://gitlab.com) como repositório remoto.

> É muito importante entender a diferença entre local e remoto!

---

## Criando uma conta

![bg fit left:30%](https://assets-global.website-files.com/5fec9210c1841a6c20c6ce81/6233f725bf42ce5a2e495bad_gitlab-logo-gray-stacked-rgb.png)

* Vá até o site [GitLab](https://gitlab.com/users/sign_up) e crie uma conta.
* Lembre-se de utilizar o mesmo e-mail e nome de usuário configurados no seu Git local.

Ao final, faça o login na sua conta.

> Para configurar usuário e e-mail no Git local, use o comando `git config --global user.name "Seu Nome de Usuário"` e `git config --global user.email "seu.email@dominio.com"`.

---

## Criando o repositório remoto (GitLab)

![bg fit right:30%](../../assets/img/gitlab_new_repo.png)

Para armazenar um novo projeto no GitLab, precisamos criar seu repositório no site:

* Procure pelo `+` no menu e selecione a opção `Novo projeto/repositório`.
* Selecione a opção `Criar projeto em branco`.

---

![bg fit left:50%](https://images.ctfassets.net/lzny33ho1g45/2sG4cuR7kWBb9BaAL1pOu4/c9922767a48bd3704df6dc3f598127eb/Blank_project_page_in_GitLab?w=1400)

* Preencha as informações necessárias.
* Selecione a visibilidade do projeto como `Pública`.
* **IMPORTANTE!**: desmarque a opção `Inicializar repositório com um README`.

---

Caso a opção de `Inicializar repositório com um README` não seja desmarcada, o GitLab inicializará um novo repositório por conta própria, o que deve causar conflitos com o repositório local.

> É possível utilizar essa opção desde que você execute a clonagem do repositório remoto e atualize os arquivos a partir dele. *(Não recomendado para iniciantes)*

---

## Criando o repositório local (Git)

![bg fit right:30%](https://i.stack.imgur.com/7BI04.png)

* Antes de tudo, organize uma pasta que será a raiz do seu projeto.
  * Copie todos os arquivos para dentro dessa pasta e organize em outras pastas se necessário.
* Utilize a opção do gerenciador de arquivos `Git Bash Here` para abrir o terminal na pasta raiz.
* Execute o comando `git init` para inicializar o seu repositório local dentro da pasta.

---

**ATENÇÃO!** Sempre certifique-se de estar na **pasta raiz** no momento da criação do repositório.

A pasta raiz é a pasta que armazena todas as outras e será a primeira referência do seu repositório.

Utilize os comandos `pwd`, `git status` e `ls` para saber onde seu repositório foi criado.

A etapa de criação do repositório só é, de maneira geral, necessária **UMA ÚNICA VEZ** para cada projeto.

---

## Commit (local)

* Ainda dentro do repositório recém-criado, certifique-se de estar no local correto (pasta raiz do seu projeto).
* Se você não fez ainda, copie/organize todos os arquivos que você quer versionar (salvar).
* Use o comando `git add .` para adicionar todos os arquivos.

> Você pode substituir o `.` no comando pelo nome individual dos arquivos e pastas que você pretende adicionar. Isso é útil quando você deseja persistir na sua versão apenas alguns dos arquivos que você alterou.

---

* Por fim, ainda na raiz, use o comando `git commit -m "Mensagem"`.
  * Substitua `"mensagem"` por uma mensagem curta descrevendo as alterações. Por boas práticas, não utilize mensagens maiores do que 50 caracteres.
* Se tudo correr corretamente, você deve ser capaz de visualizar seu novo commit usando o comando `git log`.

---

## Vinculando repositório remoto

![bg fit right:35%](https://polaris.synopsys.com/developer/assets/images/documentation/gitlab-clone.png)

Antes de enviar as alterações para o repositório **remoto** (GitLab), é necessário incluir a URL no seu novo repositório **local**.

* Para isso, use o comando `git remote add origin [URL]`.

Substitua `[URL]` pelo endereço **HTTPS** do seu repositório
