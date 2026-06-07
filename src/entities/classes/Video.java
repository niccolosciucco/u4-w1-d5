package entities.classes;

import entities.abstractClass.ElementoMultimediale;
import entities.interfaces.RegolaLuminosita;
import entities.interfaces.RegolaVolume;

public class Video extends ElementoMultimediale implements RegolaVolume, RegolaLuminosita {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getDurata() {
        return this.durata;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getLuminosita() {
        return this.luminosita;
    }

    public void alzaVolume() {
        this.volume = this.volume + 1;
    }

    public void abbassaVolume() {
        if (this.volume >= 1) {
            this.volume = this.volume - 1;
        }
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