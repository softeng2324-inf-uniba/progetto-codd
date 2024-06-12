package it.uniba.app.utente;
import it.uniba.app.campodagioco.Tavoliere;
/**
 * <<ENTITY>>
 * Classe del giocatore.
 */
public class Giocatore {
    private final String nome;
    /**
     * Metodo del costruttore di Giocatore.
     * @param n nome del giocatore.
     */
    public Giocatore(final String n) {
        final int maxCharNome = 15;
        if (n.length() > maxCharNome) {
            this.nome = n.substring(0, maxCharNome);
        } else {
            this.nome = n;
        }
    }

    /**
     * Metodo che restituisce il nome del giocatore.
     * @return stringa contenente il nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo che controlla se la mossa effettuata è effettuabile.
     * @param tav tavoliere.
     * @param mossa array di coordinate della mossa.
     * @param giocatore numero del giocatore che ha effettuato la mossa.
     * @return true se mossa valida.
     */
    public boolean controllaMossa(final Tavoliere tav, final int[] mossa, final int giocatore) {
        final int letteraArrivo = 2;
        final int numeroArrivo = 3;
        int colonnaPartenza = mossa[0];
        int rigaPartenza = mossa[1];
        int colonnaArrivo = mossa[letteraArrivo];
        int rigaArrivo = mossa[numeroArrivo];

        int idCella = tav.getIdTav(rigaPartenza, colonnaPartenza);
        if (idCella != giocatore) {
            return false;
        }
        double distanza = Math.sqrt(Math.pow(colonnaArrivo - colonnaPartenza, 2)
            + Math.pow(rigaArrivo - rigaPartenza, 2));
        final int maxDistance = 3;
        return !(distanza >= maxDistance) && tav.getIdTav(rigaArrivo, colonnaArrivo) == Tavoliere.CAS_VUOTA;
    }


    /**
     * Metodo che cambia il valore delle Celle nel Tavoliere.
     * @param tav tavoliere.
     * @param mossa array delle coordinate della mossa.
     * @param giocatore numero del giocatore in turno.
     * @return tavoliere modificato.
     */
    public Tavoliere mossaGiocatore(final Tavoliere tav, final int[] mossa, final int giocatore) {
        final int coordinataArrivoX = 2;
        final int coordinataArrivoY = 3;
        double distanza = Math.sqrt(Math.pow(mossa[coordinataArrivoX] - mossa[0], 2)
            + Math.pow(mossa[coordinataArrivoY] - mossa[1], 2));
        if (distanza < 2) {
            tav.setIdTav(mossa[coordinataArrivoY], mossa[coordinataArrivoX], giocatore);
            if (giocatore == 0) {
                tav.setPedine(Tavoliere.PG1, tav.getPedine(Tavoliere.PG1) + 1);
            } else {
                tav.setPedine(Tavoliere.PG2, tav.getPedine(Tavoliere.PG2) + 1);
            }
        }  else {
            tav.setIdTav(mossa[1], mossa[0], Tavoliere.CAS_VUOTA);
            tav.setIdTav(mossa[coordinataArrivoY], mossa[coordinataArrivoX], giocatore);
        }
        return tav;
    }




}
