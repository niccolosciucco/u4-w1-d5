package entities.abstractClass;

public abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void esegui(boolean riproduci, int durata, int volume, int luminosita) {
        if (riproduci == true) {

            for (int i = 0; i < durata; i++) {
                System.out.print(this.titolo + " ");

                for (int y = 0; y < volume; y++) {
                    System.out.print("!");
                }

                for (int a = 0; a < luminosita; a++) {
                    System.out.print("*");
                }
                System.out.println(" ");
            }
        } else {
            System.out.print(this.titolo + " ");
            for (int b = 0; b < luminosita; b++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
