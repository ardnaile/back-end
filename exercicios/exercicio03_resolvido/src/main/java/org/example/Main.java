package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        // Inicializando o context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Puxando o bean do serviço dentro do contexto
        OscarService myService = context.getBean(OscarService.class);

        // Criando um novo filme e um novo ator (indicaveis)
        Filme meuFilme = new Filme();
        meuFilme.setElegivel(true);
        meuFilme.incrementarIndicacoes();

        Ator meuAtor = new Ator();
        meuAtor.setElegivel(true);
        meuAtor.incrementarIndicacoes();

        // Utilizando um método do serviço que puxamos pelo bean
        myService.adicionarIndicacao(meuFilme, "Ficção");
        myService.adicionarIndicacao(meuAtor, "Melhor ator");
    }
}


