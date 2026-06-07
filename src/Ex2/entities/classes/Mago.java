package Ex2.entities.classes;

import Ex2.entities.abstractClass.Personaggio;
import Ex2.entities.interfaces.AbilitaSpeciale;
import Ex2.entities.interfaces.Combattente;

public class Mago extends Personaggio implements Combattente, AbilitaSpeciale {
    private int potereMagico;
    private int mana;

    public Mago(String nome, int energia, int livello, int potereMagico, int mana) {
        super(nome, energia, livello);
        this.potereMagico = potereMagico;
        this.mana = mana;
    }

    public int getPotereMagico() {
        return this.potereMagico;
    }

    public int getMana() {
        return this.mana;
    }

    public void ricarica() {
        this.mana = this.mana + 10;
        System.out.println(this.nome + " ha un nuovo mana: " + this.mana);
    }

    public void agisci(Personaggio avversario) {
        if (this.energia <= 0 || this.mana <= 0) {
            System.out.println(this.nome + " non riesce ad agire");
            return;
        }

        int danno = (this.potereMagico * this.mana * this.livello) / 5;
        int riduzioneMana = danno / 3;

        this.mana = this.mana - riduzioneMana;
        if (this.mana < 0) {
            this.mana = 0;
        }

        super.gestisciAzione(true, avversario, danno, riduzioneMana, "mana");
    }
}