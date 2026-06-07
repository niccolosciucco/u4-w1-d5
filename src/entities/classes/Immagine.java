package entities.classes;

import entities.abstractClass.ElementoMultimediale;
import entities.interfaces.RegolaLuminosita;

public class Immagine extends ElementoMultimediale implements RegolaLuminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return this.luminosita;
    }

    public void aumentaLuminosita() {
        this.luminosita = this.luminosita + 1;
    }

    public void diminuisciLuminosita() {
        if (this.luminosita >= 1) {
            this.luminosita = this.luminosita - 1;
        }
    }
}