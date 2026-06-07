import entities.abstractClass.ElementoMultimediale;
import entities.classes.Immagine;
import entities.classes.RegistrazioneAudio;
import entities.classes.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] array = new ElementoMultimediale[5];

        System.out.println("-----------------------------------");

        for (int i = 0; i < 5; i++) {
            System.out.println("\nInserisci elemento numero " + (i + 1));
            System.out.println("Premi: 1 per Audio, 2 per Video, 3 per Immagine");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Serve per pulire la memoria, atlrimenti non funziona

            if (tipo < 1 || tipo > 3) {
                System.out.println("Errore: Tipo non valido! Reinserisci l'elemento.");
                // Prima di fare il continue, riporto l'indice alla posizione di partenza di questo giro, così non perdo il giro
                i--;
                continue;
            }

            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            if (tipo == 1) {
                System.out.println("Inserisci durata:");
                int durata = scanner.nextInt();
                System.out.println("Inserisci volume:");
                int volume = scanner.nextInt();
                scanner.nextLine();
                array[i] = new RegistrazioneAudio(titolo, durata, volume);
            } else if (tipo == 2) {
                System.out.println("Inserisci durata:");
                int durata = scanner.nextInt();
                System.out.println("Inserisci volume:");
                int volume = scanner.nextInt();
                System.out.println("Inserisci luminosità:");
                int lum = scanner.nextInt();
                scanner.nextLine();
                array[i] = new Video(titolo, durata, volume, lum);
            } else if (tipo == 3) {
                System.out.println("Inserisci luminosità:");
                int lum = scanner.nextInt();
                scanner.nextLine();
                array[i] = new Immagine(titolo, lum);
            }
        }

        int index = 1;
        while (index != 0) {
            System.out.println("Quale oggetto vuoi eseguire? (Scegli da 1 a 5, oppure 0 per finire)");
            index = scanner.nextInt();

            if (index >= 1 && index <= 5) {
                ElementoMultimediale elementoScelto = array[index - 1];

                if (elementoScelto != null) {
                    if (elementoScelto instanceof RegistrazioneAudio) {
                        RegistrazioneAudio audio = (RegistrazioneAudio) elementoScelto;
                        elementoScelto.esegui(true, audio.getDurata(), audio.getVolume(), 0);
                    } else if (elementoScelto instanceof Video) {
                        Video video = (Video) elementoScelto;
                        elementoScelto.esegui(true, video.getDurata(), video.getVolume(), video.getLuminosita());
                    } else if (elementoScelto instanceof Immagine) {
                        Immagine img = (Immagine) elementoScelto;
                        elementoScelto.esegui(false, 0, 0, img.getLuminosita());
                    }
                } else {
                    System.out.println("Errore: Posizione vuota!");
                }
            } else if (index != 0) {
                System.out.println("Errore: inserisci un numero corretto!");
            }
        }
    }
}