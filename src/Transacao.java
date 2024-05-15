import java.util.List;
import java.util.Random;

public class Transacao {


    private static final int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagamentos, tempo, tempoExtra;
    private Guiche guiche = new Guiche();
    private Clientes clientes = new Clientes();
    private Random random = new Random();


    public Transacao() {
        this.tempoTransacao = 0;
        this.deposito = 0;
        this.pagamentos = 0;
        this.saques = 0;
        this.tempo = 0;
        this.tempoExtra = 0;
    }

    public String transacaoRealizada() {
        List<Guiche> guicheLista = guiche.listaGuiche();
        while (tempo <= ATENDIMENTO) {

            if (clientes.chegouCliente()){
                    for (Guiche value : guicheLista) {
                        if (value.isGuicheLivre()) {
                            value.setGuicheLivre(false);
                            tipoTransacao();
                            value.setTempoOcupado(tempoTransacao);
                            break;
                        }
                }
            }
            tempo++;
            guiche.guicheDisponivel(guicheLista, tempo);


            if (tempo >= ATENDIMENTO) {
                tempoExtra++;
            }
        }
        return resultado();
    }

    public void tipoTransacao(){
        switch (random.nextInt(3)) {
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
                System.out.println("Código Inválido");
        }
    }
    public String resultado(){
        return "Total de clientes atendidos: " + clientes.getTotalClientes() + "\n" +
        "Número de clientes que realizaram saque: " + saques + "\n" +
        "Número de clientes que realizaram depósito: " + deposito + "\n" +
        "Número de clientes que realizaram pagamento: " + pagamentos + "\n" +
        "Tempo médio de espera na fila: " + "\n" +
        "Tempo extra de expediente: " + tempoExtra;






    }
}
