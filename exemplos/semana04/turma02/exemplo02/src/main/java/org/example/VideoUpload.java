package org.example;

public class VideoUpload {
    Video video;
    short percentageProgress = 0;

    public VideoUpload(Video video) {
        this.video = video;
    }

    public void startUpload() {
        if (video == null) {
            System.out.println("Um vídeo precisa ser especificado no upload");
            return;
        }
        while (percentageProgress < 100) {
            try {
                Thread.currentThread().sleep(100); // Pause a thread por 0.1 seg
                System.out.println("Uploading: " + percentageProgress + "% ...");
                percentageProgress += 10 + (Math.random() * 5); // Apenas por estética, upload é feito com número aleatório
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida");
            }
        }
        video.setOnline(true);
        System.out.println("Upload finalizado!");
    }
}
