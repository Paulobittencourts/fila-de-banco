import java.util.List;

public class Transacao {

    private int codigo;

    private static int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagamentos, tempo, tempoExtra;
    private Guiche guiche = new Guiche();


    public Transacao() {
        this.tempoTransacao = 0;
        this.deposito = 0;
        this.pagamentos = 0;
        this.saques = 0;
        this.tempo = 0;
        this.tempoExtra = 0;
    }

    public int trasacaoRealizada(int codigo){
        List<Guiche> guicheLista = guiche.listaGuiche();
        while (tempo <= ATENDIMENTO){

            if (tempo >= ATENDIMENTO){
                tempoExtra++;
            }
            if(guiche.validaGuiche(guicheLista)){
                for(int i = 0; i <= 2; i++){
                    if(guicheLista.get(i).isGuicheLivre()){
                        switch (codigo){
                            case 0:
                                tempoTransacao = tempo + 60;
                                saques++;
                                break;
                            case 1:
                                tempoTransacao = tempo + 90;
                                deposito++;
                                break;
                            case 2:
                                tempoTransacao = tempo + 120;
                                pagamentos++;
                                break;
                        }
                    }
                }
            }
            tempo++;
        }
        return tempoTransacao;
    }
}
