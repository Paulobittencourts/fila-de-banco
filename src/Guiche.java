import java.util.ArrayList;
import java.util.List;

public class Guiche {

    private boolean guicheLivre = true;
    private int tempoOcupado = 0;

    public List<Guiche> listaGuiche() {
        ArrayList<Guiche> listaGuiche = new ArrayList<>(3);
        for (int i = 0; i <= 2; i++) {
            listaGuiche.add(new Guiche());
        }
        return listaGuiche;
    }

    public void guicheDisponivel(List<Guiche> guiches, int tempo) {
        for (int i = 0; i < guiches.size(); i++) {
            if (!guiches.get(i).isGuicheLivre() && tempo == guiches.get(i).getTempoOcupado()) {
                guiches.get(i).setGuicheLivre(true);
            }
        }
    }

    public boolean todosGuichesLivres(List<Guiche> guiches) {
        for (Guiche guiche : guiches) {
            if (!guiche.isGuicheLivre()) {
                return false;
            }
        }
        return true;
    }


    public boolean isGuicheLivre() {
        return guicheLivre;
    }

    public void setGuicheLivre(boolean guicheLivre) {
        this.guicheLivre = guicheLivre;
    }

    public int getTempoOcupado() {
        return tempoOcupado;
    }

    public void setTempoOcupado(int tempoOcupado) {
        this.tempoOcupado = tempoOcupado;
    }
}
