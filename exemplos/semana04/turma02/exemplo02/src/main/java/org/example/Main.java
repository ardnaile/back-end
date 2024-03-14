package org.example;

public class Main {
    public static void main(String[] args) {
        // Criando usuários
        User userTim = new User("tim", "tim@fake.com");
        User userMia = new User("mia", "mia@fake.com");

        // Criando um novo post
        Post myPost = new Post("Gatinhos cantando", userTim);

        // Iniciando o upload do post
        VideoUpload upload = new VideoUpload(myPost);
        upload.startUpload();

        // Interagindo com o post
        myPost.like(userMia);
        myPost.comment(userMia, "Achei muito fofo!");
        myPost.showComments();
        System.out.println("Número de Likes: " + myPost.getLikes());

        // Criando um story
        Story myStory = new Story(userMia);

        // Iniciando upload do story
        upload = new VideoUpload(myStory);
        upload.startUpload();

        // Interagindo com o story
        myStory.like(userTim);

        // Exportando dados do post
        JSONExporter exporter = new JSONExporter();
        String json = exporter.convertToJson(myPost);
        System.out.println(json);
    }
}