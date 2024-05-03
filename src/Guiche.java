import java.util.ArrayList;
import java.util.List;

public class Guiche {

    private boolean guicheLivre = true;
    private int tempoOcupado = 0;

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

    public List<Guiche> listaGuiche(){
        ArrayList<Guiche> listaGuiche = new ArrayList<>(3);
        for(int i = 0; i <=2; i++){
            listaGuiche.add(new Guiche());
            listaGuiche.get(i);
        }
        return listaGuiche;
    }

    public boolean validaGuiche(List<Guiche> guiches){
        for(int i = 0; i < guiches.size();i++){
            if(!guiches.get(i).isGuicheLivre()){
               setGuicheLivre(false);
            }
        }
        return isGuicheLivre();
    }
    public void guicheDisponivel(List<Guiche> guiches, int tempo ){
        for(int i = 0; i < guiches.size();i++) {
            if (!guiches.get(i).isGuicheLivre() && guiches.get(i).getTempoOcupado() == tempo) {
                setGuicheLivre(true);
            }
        }
    }
}
