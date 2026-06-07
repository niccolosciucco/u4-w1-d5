package entities.classes;

import entities.abstractClass.ElementoMultimediale;
import entities.interfaces.RegolaVolume;

public class RegistrazioneAudio extends ElementoMultimediale implements RegolaVolume {
    private int durata;
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public int getDurata() {
        return this.durata;
    }

    public int getVolume() {
        return this.volume;
    }

    public void alzaVolume() {
        this.volume = this.volume + 1;
    }

    public void abbassaVolume() {
        if (this.volume >= 1) {
            this.volume = this.volume - 1;
        }
    }
}