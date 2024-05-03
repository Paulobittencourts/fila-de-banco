import java.util.List;

public class Transacao {


    private static int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagamentos, tempo, tempoExtra,totalCliente;
    private Guiche guiche = new Guiche();
    private  Clientes clientes = new Clientes();


    public Transacao() {
        this.tempoTransacao = 0;
        this.deposito = 0;
        this.pagamentos = 0;
        this.saques = 0;
        this.tempo = 0;
        this.tempoExtra = 0;
        this.totalCliente = 0;
    }

    public int transacaoRealizada(int codigo){
        List<Guiche> guicheLista = guiche.listaGuiche();
        while (tempo <= ATENDIMENTO){

            if (tempo >= ATENDIMENTO){
                tempoExtra++;
            }
            if (tempo <= ATENDIMENTO) {
                if (clientes.chegouCliente())
                    totalCliente++;
            }
            if(guiche.validaGuiche(guicheLista)){
                for(Guiche value:guicheLista){
                    if(value.isGuicheLivre()){
                        value.setGuicheLivre(false);
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
                   value.setTempoOcupado(tempoTransacao);
                    }
                }
            }
            guiche.guicheDisponivel(guicheLista,tempo);
            tempo++;
        }
        return tempoTransacao;
    }
}
