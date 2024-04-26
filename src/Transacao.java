import java.util.Random;

public class Transacao {

    private int codigo;

    private static int ATENDIMENTO = 21600;
    private int tempoTransacao;
    private int saques, deposito, pagametos, tempo, tempoExtra;


    public Transacao() {
        this.tempoTransacao = 0;
        this.deposito = 0;
        this.pagametos = 0;
        this.saques = 0;
        this.tempo = 0;
        this.tempoExtra = 0;
    }

    public int trasacaoRealizada(int codigo){
        while (tempo <= ATENDIMENTO){

            if (tempo >= ATENDIMENTO){
                tempoExtra++;
            }
            for(int i = 0; i <= 2; i++){
                switch (codigo){
                    case 0:
                        tempoTransacao = tempo + 60;
                        saques++;
                        break;
                    case 1:
                        tempoTransacao = tempo + 90;
                        deposito++;
                        break;
                    case 3:
                        tempoTransacao = tempo + 120;
                        pagametos++;
                        break;
                }
            }
            tempo++;
        }
        return tempoTransacao;
    }
}
