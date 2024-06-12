package it.uniba.app.campodagioco;
import it.uniba.app.utilita.Comandi;
/**
 * <<ENTITY>>.
 * Classe che rappresenta il tavolo da gioco
 */

 public class Tavoliere {
    public static final int DIM_TAV = 7;
    public static final int CAS_VUOTA = 2;
    public static final int PG1 = 0;
    public static final int PG2 = 1;
    public static final int CAS_GIAL = 3;
    public static final int CAS_ARAN = 4;
    public static final int CAS_ROSA = 5;

    private Cella[][] tavoliere;
    private int[] pedine;

    /**
     * Costruttore di Tavoliere.
     */
    public Tavoliere() {
        tavoliere = new Cella[DIM_TAV][DIM_TAV];
        for (int i = 0; i < DIM_TAV; i++) {
            for (int j = 0; j < DIM_TAV; j++) {
                tavoliere[i][j] = new Cella();
            }
        }
        pedine = new int[2];
    }


    /**
     * Metodo d'accesso per l'array delle pedine.
     * @param giocatore numero del giocatore in turno.
     * @return numero delle pedine del colore del giocatore.
     */
    public int getPedine(final int giocatore) {
        return pedine[giocatore];
    }

    /**
     * Metodo d'accesso per l'array delle pedine.
     * @param giocatore numero del giocatore in turno.
     * @param v valore da aggiungere.
     */

    public void setPedine(final int giocatore, final int v) {
        pedine[giocatore] = v;
    }
    /**
     * Metodo che inizializza il tavoliere aggiungendo le pedine iniziali.
     * @param tav Tavoliere da inizializzare
     */
    public static void inizializzaTavoliere(final Tavoliere tav) {
        //imposta le 4 pedine iniziali e salva il numero.
        tav.tavoliere[0][0].setId(PG1);
        tav.tavoliere[0][DIM_TAV - 1].setId(PG2);
        tav.tavoliere[DIM_TAV - 1][0].setId(PG2);
        tav.tavoliere[DIM_TAV - 1][DIM_TAV - 1].setId(PG1);
        tav.setPedine(PG1, tav.getPedine(PG1) + 2);
        tav.setPedine(PG2, tav.getPedine(PG2) + 2);
    }

    /**
     * Metodo che restituisce il valore della Cella selezionata.
     * @param x righe.
     * @param y colonne.
     * @return valore cella
     */
    public int getIdTav(final int x, final int y) {
        return tavoliere[x][y].getId();
    }

    /**
     * Metodo che imposta il valore di una cella.
     * @param x riga.
     * @param y colonna.
     * @param valore valore da inserire.
     */
    public void setIdTav(final int x, final int y, final int valore) {
        tavoliere[x][y].setId(valore);
    }


    /**
     * Metodo che stampa a video un tabellone vuoto.
     * @return tavoliere stampato
     */
    public static String stampaTabelloneVuoto() {
        Tavoliere tav = new Tavoliere();
        String str;
        str = tav.toString();
        return str;
    }

    /**
     * Metodo che cambia il colore delle pedine conquistare.
     * @param mosse array con le coordinate della posizione d'arrivo della pedina.
     * @param turno numero del giocatore in turno.
     * @return Tavoliere modificato.
     */
    public Tavoliere conquistaPedine(final int[] mosse, final int turno) { //inserito
        final int posCoordinataX = 3;
        final int posCoordinataY = 2;
        final int posX = mosse[posCoordinataY];
        final int posY = mosse[posCoordinataX];
        for (int x = Math.max(0, posX - 1); x <= Math.min(posX + 1, tavoliere.length - 1); x++) {
            for (int y = Math.max(0, posY - 1); y <= Math.min(posY + 1, tavoliere[x].length - 1); y++) {
                if (tavoliere[y][x].getId() == Comandi.altroGiocatore(turno)) {
                    setIdTav(y, x, turno);
                    if (turno == 0) {
                        setPedine(PG1, getPedine(PG1) + 1);
                        setPedine(PG2, getPedine(PG2) - 1);
                    } else {
                        setPedine(PG1, getPedine(PG1) - 1);
                        setPedine(PG2, getPedine(PG2) + 1);
                    }
                }
            }
        }
        return this;
    }

    /**
     * Metodo che stampa a video il tabellone con le mosse possibili del giocatore "g".
     * @param g intero che rappresenta la pedina del giocatore
     */
    public void qualiMosse(final int g) {
        Cella[][] copiaTav = copiaTavoliere();
        compilaArrayStampa(copiaTav, g);
        System.out.println(toString(copiaTav));
    }

    /**
     * Metodo che cerca pedina del giocatore per poi usare funzione coloraCaselleAdiacenti.
     *
     * @param tav matrice che rappresenta il tavoliere
     * @param g   numero del giocatore
     */
    private void compilaArrayStampa(final Cella[][] tav, final int g) {
        for (int i = 0; i < DIM_TAV; i++) {
            for (int j = 0; j < DIM_TAV; j++) {
                if (tav[i][j].getId() == g) {
                    coloraCaselleAdiacenti(tav, i, j);
                }
            }
        }
    }

    /**
     * Metodo che calcola le caselle adiacenti e inserisce valori colore caselle nella matrice.
     *
     * @param tav matrice da "colorare"
     * @param i   numero della riga dove si trova la pedina giocatore
     * @param j   numero della colonna dove si trova la pedina giocatore
     */
    private void coloraCaselleAdiacenti(final Cella[][] tav, final int i, final int j) {
        final int maxRange = 3;
        for (int x = Math.max(0, i - 2); x < Math.min(i + maxRange, tav.length); x++) {
            for (int y = Math.max(0, j - 2); y < Math.min(j + maxRange, tav[x].length); y++) {
                double distanza = Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
                if (distanza >= 2) {
                    if (tav[x][y].getId() == CAS_GIAL) {
                        tav[x][y].setId(CAS_ROSA);
                    }
                    if (tav[x][y].getId() == CAS_VUOTA) {
                        tav[x][y].setId(CAS_ARAN);
                    }
                }
                if (distanza < 2) {
                    if (tav[x][y].getId() == CAS_ARAN) {
                        tav[x][y].setId(CAS_ROSA);
                    }
                    if (tav[x][y].getId() == CAS_VUOTA) {
                        tav[x][y].setId(CAS_GIAL);
                    }
                }
            }
        }
    }

    /**
     * Metodo per creare una copia profonda del tavoliere.
     * @return una copia profonda del tavoliere
     */
    private Cella[][] copiaTavoliere() {
        Cella[][] copia = new Cella[DIM_TAV][DIM_TAV];
        for (int i = 0; i < DIM_TAV; i++) {
            for (int j = 0; j < DIM_TAV; j++) {
                copia[i][j] = new Cella(this.tavoliere[i][j].getId());
            }
        }
        return copia;
    }


    /**
     * Metodo che costruisce la stringa del tavoliere.
     * @return stringa da stampare
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        int x = 0;
        str.append("   a b c d e f g\n");
        for (int i = 0; i < DIM_TAV; i++) {
            str.append((i + 1)).append("|");
            for (int j = 0; j < DIM_TAV; j++) {
                if (tavoliere[i][j].getId() == PG1) {
                    str.append("⚫");
                    x++;
                } else if (tavoliere[i][j].getId() == PG2) {
                    str.append("⚪");
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_VUOTA) {
                    if (x % 2 == 0) {
                        str.append("\033[96m░░\033[0m");
                    } else {
                        str.append("\033[36m▓▓\033[0m");
                    }
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_GIAL) {
                    str.append("\u001B[33m▓▓\u001B[0m");
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_ARAN) {
                    str.append("\u001B[38;5;208m▓▓\u001B[0m");
                    x++;
                } else if (tavoliere[i][j].getId() == CAS_ROSA) {
                    str.append("\u001B[38;5;205m▓▓\u001B[0m");
                    x++;
                }

            }
            str.append("|").append(i + 1).append("\n");
        }
        str.append("   a b c d e f g");
        return str.toString();
    }

    /**
     * Metodo che costruisce la stringa del tavoliere messo in input.
     * @param tav matrice del tavoliere
     * @return stringa da stampare
     */
    public String toString(final Cella[][] tav) {
        StringBuilder str = new StringBuilder();
        int x = 0;
        str.append("   a b c d e f g\n");
        for (int i = 0; i < DIM_TAV; i++) {
            str.append((i + 1)).append("|");
            for (int j = 0; j < DIM_TAV; j++) {
                if (tav[i][j].getId() == PG1) {
                    str.append("⚫");
                    x++;
                } else if (tav[i][j].getId() == PG2) {
                    str.append("⚪");
                    x++;
                } else if (tav[i][j].getId() == CAS_VUOTA) {
                    if (x % 2 == 0) {
                        str.append("\033[96m░░\033[0m");
                    } else {
                        str.append("\033[36m▓▓\033[0m");
                    }
                    x++;
                } else if (tav[i][j].getId() == CAS_GIAL) {
                    str.append("\u001B[33m▓▓\u001B[0m");
                    x++;
                } else if (tav[i][j].getId() == CAS_ARAN) {
                    str.append("\u001B[38;5;208m▓▓\u001B[0m");
                    x++;
                } else if (tav[i][j].getId() == CAS_ROSA) {
                    str.append("\u001B[38;5;205m▓▓\u001B[0m");
                    x++;
                }

            }
            str.append("|").append(i + 1).append("\n");
        }
        str.append("   a b c d e f g");
        return str.toString();
    }
}
