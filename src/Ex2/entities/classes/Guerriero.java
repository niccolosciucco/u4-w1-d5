package Ex2.entities.classes;

import Ex2.entities.abstractClass.Personaggio;
import Ex2.entities.interfaces.AbilitaSpeciale;
import Ex2.entities.interfaces.Combattente;

public class Guerriero extends Personaggio implements Combattente, AbilitaSpeciale {
    private int forza;
    private int resistenza;

    public Guerriero(String nome, int energia, int livello, int forza, int resistenza) {
        super(nome, energia, livello);
        this.forza = forza;
        this.resistenza = resistenza;
    }

    public int getForza() {
        return this.forza;
    }

    public int getResistenza() {
        return this.resistenza;
    }

    public void ricarica() {
        this.resistenza = this.resistenza + 1;
        System.out.println(this.nome + " ha una nuova resistenza: " + this.resistenza);
    }

    public void agisci(Personaggio avversario) {
        if (this.energia <= 0) {
            System.out.println(this.nome + " non riesce ad agire!");
            return;
        }

        int danno = (this.forza * this.resistenza * this.livello) / 10;
        int riduzionePropria = danno / 5;

        super.gestisciAzione(true, avversario, danno, riduzionePropria, "energia");
    }
}