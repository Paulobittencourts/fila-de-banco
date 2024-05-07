import java.util.List;

public class Transacao {


    private static final int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagamentos, tempo, tempoExtra;
    private Guiche guiche = new Guiche();
    private Clientes clientes = new Clientes();


    public Transacao() {
        this.tempoTransacao = 0;
        this.deposito = 0;
        this.pagamentos = 0;
        this.saques = 0;
        this.tempo = 0;
        this.tempoExtra = 0;
    }

    public int transacaoRealizada(int codigo) {
        List<Guiche> guicheLista = guiche.listaGuiche();
        while (tempo <= ATENDIMENTO) {

            if (clientes.chegouCliente()){

            }
            if (guiche.validaGuiche(guicheLista)) {
                for (Guiche value : guicheLista) {
                    if (value.isGuicheLivre()) {
                        value.setGuicheLivre(false);
                        switch (codigo) {
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
                            default:
                                System.out.println("Codigo Invalido");
                        }
                        value.setTempoOcupado(tempoTransacao);
                        break;
                    }
                }
            }
            guiche.guicheDisponivel(guicheLista, tempo);
            tempo++;

            if (tempo >= ATENDIMENTO) {
                tempoExtra++;
            }
        }
        return tempoTransacao;
    }
}
