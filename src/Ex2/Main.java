package Ex2;

import Ex2.entities.abstractClass.Personaggio;
import Ex2.entities.classes.Guerriero;
import Ex2.entities.classes.Mago;
import Ex2.entities.classes.Mercante;
import Ex2.entities.interfaces.Combattente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanti personaggi vuoi creare?");
        int tot = scanner.nextInt();
        scanner.nextLine();

        Personaggio[] array = new Personaggio[tot];

        for (int i = 0; i < tot; i++) {
            System.out.println("Creazione personaggio " + (i + 1));
            System.out.println("Premi: 1 per Guerriero, 2 per Mago, 3 per Mercante");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            if (tipo < 1 || tipo > 3) {
                System.out.println("Errore: Tipo errato! Riprova.");
                i--;
                continue;
            }

            System.out.println("Inserisci il nome:");
            String nome = scanner.nextLine();
            System.out.println("Inserisci energia iniziale:");
            int energia = scanner.nextInt();
            System.out.println("Inserisci livello iniziale:");
            int livello = scanner.nextInt();

            if (tipo == 1) {
                System.out.println("Inserisci forza:");
                int forza = scanner.nextInt();
                System.out.println("Inserisci resistenza:");
                int resistenza = scanner.nextInt();
                scanner.nextLine();
                array[i] = new Guerriero(nome, energia, livello, forza, resistenza);
            } else if (tipo == 2) {
                System.out.println("Inserisci potere magico:");
                int pot = scanner.nextInt();
                System.out.println("Inserisci mana:");
                int mana = scanner.nextInt();
                scanner.nextLine();
                array[i] = new Mago(nome, energia, livello, pot, mana);
            } else if (tipo == 3) {
                System.out.println("Inserisci ricchezza:");
                int ricchezza = scanner.nextInt();
                System.out.println("Inserisci numero oggetti posseduti:");
                int oggetti = scanner.nextInt();
                scanner.nextLine();
                array[i] = new Mercante(nome, energia, livello, ricchezza, oggetti);
            }
        }

        System.out.println("--- LISTA PERSONAGGI DISPONIBILI ---");
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ". ");
            // false cosi fa vedere lo stato di tutti
            array[i].gestisciAzione(false, null, 0, 0, "");
        }

        System.out.println("Scegli il numero del PRIMO personaggio che attacca:");
        int p1 = scanner.nextInt() - 1;
        System.out.println("Scegli il numero del SECONDO personaggio che difende:");
        int p2 = scanner.nextInt() - 1;

        Personaggio sfidante1 = array[p1];
        Personaggio sfidante2 = array[p2];

        System.out.println("--- INIZIO COMBATTIMENTO ---");

        // finchè hanno energia, si va avanti
        while (sfidante1.getEnergia() > 0 && sfidante2.getEnergia() > 0) {

            if (sfidante1 instanceof Combattente) {
                Combattente c1 = (Combattente) sfidante1;
                c1.agisci(sfidante2);
            } else {
                System.out.println(sfidante1.getNome() + " è un mercante, non sa combattere!");
            }

            if (sfidante2.getEnergia() > 0 && sfidante2 instanceof Combattente) {
                Combattente c2 = (Combattente) sfidante2;
                c2.agisci(sfidante1);
            } else if (sfidante2.getEnergia() > 0) {
                System.out.println(sfidante2.getNome() + " subisce l'azione");
            }

            System.out.println("--- STATO AGGIORNATO COMPATTIMENTO ---");
            sfidante1.gestisciAzione(false, null, 0, 0, "");
            sfidante2.gestisciAzione(false, null, 0, 0, "");
            System.out.println(" ");
        }
    }
}
