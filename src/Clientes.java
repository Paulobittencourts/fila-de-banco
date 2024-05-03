import java.util.Random;

public class Clientes {

    private int horaDeEntrada;
    private Random aleatorio = new Random();

    public Clientes() {
    }

    public Clientes(int horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public boolean chegouCliente(){

        int pessoas = aleatorio.nextInt(30);
        return pessoas == 0;

    }
}

