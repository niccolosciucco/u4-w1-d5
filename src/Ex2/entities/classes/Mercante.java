package Ex2.entities.classes;

import Ex2.entities.abstractClass.Personaggio;

public class Mercante extends Personaggio {
    private int ricchezza;
    private int numeroOggetti;

    public Mercante(String nome, int energia, int livello, int ricchezza, int numeroOggetti) {
        super(nome, energia, livello);
        this.ricchezza = ricchezza;
        this.numeroOggetti = numeroOggetti;
    }

    public int getRicchezza() {
        return this.ricchezza;
    }

    public int getNumeroOggetti() {
        return this.numeroOggetti;
    }
}