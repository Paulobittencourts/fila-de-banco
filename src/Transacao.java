import java.util.List;
import java.util.Random;

public class Transacao {


    private static final int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagamentos, tempo, tempoExtra, tempoEspera;
    private Guiche guiche = new Guiche();
    private Clientes clientes = new Clientes();
    private Random random = new Random();
    private FilaCliente fila = new FilaCliente();


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
        while (tempo <= ATENDIMENTO || !fila.isEmpty()) {
            if (clientes.chegouCliente(tempo)){
                    for (Guiche value : guicheLista) {
                        if (value.isGuicheLivre()) {
                            value.setGuicheLivre(false);
                            tipoTransacao();
                            value.setTempoOcupado(tempoTransacao);
                            tempoEspera += tempo - fila.dequeue();
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

    private void tipoTransacao(){
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

    private String calcularMedia (){
        int mediaEspera = tempoEspera / clientes.getTotalClientes();
        return calcularHorario(mediaEspera);

    }

    private String calcularHorario(int mediaEspera){
        mediaEspera = mediaEspera % 86400;
        int hora = mediaEspera / 3600;
        mediaEspera = mediaEspera % 3600;
        int minutos = mediaEspera / 60;
        mediaEspera = mediaEspera % 60;
        int segundos = mediaEspera;
        return  hora + "Hs " + minutos + "m " + segundos + "s";
    }
    private String resultado(){
        return "Total de clientes atendidos: " + clientes.getTotalClientes() + "\n" +
        "Número de clientes que realizaram saque: " + saques + "\n" +
        "Número de clientes que realizaram depósito: " + deposito + "\n" +
        "Número de clientes que realizaram pagamento: " + pagamentos + "\n" +
        "Tempo médio de espera na fila: " + calcularMedia() + "\n" +
        "Tempo extra de expediente: " + tempoExtra;






    }
}
