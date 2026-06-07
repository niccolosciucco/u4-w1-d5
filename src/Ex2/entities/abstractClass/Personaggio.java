package Ex2.entities.abstractClass;

public abstract class Personaggio {
    protected String nome;
    protected int energia;
    protected int livello;

    public Personaggio(String nome, int energia, int livello) {
        this.nome = nome;
        this.energia = energia;
        this.livello = livello;
    }

    public String getNome() {
        return this.nome;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getLivello() {
        return this.livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    // Se attacca gli arriva true, combatte, altrimenti mostra stato
    public void gestisciAzione(boolean attacca, Personaggio nemico, int calcoloDanno, int riduzioneRisorsa, String tipoRisorsa) {
        if (attacca == true) {
            System.out.println(this.nome + " ATTACCA " + nemico.getNome());
            System.out.println("Danno inflitto: " + calcoloDanno);

            // Leva energia al nemico
            int nuovaEnergiaNemico = nemico.getEnergia() - calcoloDanno;
            if (nuovaEnergiaNemico < 0) {
                nuovaEnergiaNemico = 0;
            }

            nemico.setEnergia(nuovaEnergiaNemico);

            if (tipoRisorsa.equals("energia")) {
                this.energia = this.energia - riduzioneRisorsa;
                if (this.energia < 0) {
                    this.energia = 0;
                }

                System.out.println("L'energia di " + this.nome + " si riduce di " + riduzioneRisorsa);
            } else if (tipoRisorsa.equals("mana")) {
                System.out.println("Il mana di " + this.nome + " si riduce di " + riduzioneRisorsa);
            }

            if (nemico.getEnergia() <= 0) {
                this.livello = this.livello + 1;
                System.out.println(this.nome + " ha vinto e sale di livello " + this.livello);
            }
        } else {
            System.out.println("Nome: " + this.nome + " | Energia: " + this.energia + " | Livello: " + this.livello);
        }
    }
}