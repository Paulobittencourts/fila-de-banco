import java.util.Random;

public class Clientes {

    private int horaDeEntrada;
    private final Random aleatorio = new Random();
    private int totalClientes = 0;

    public Clientes() {
    }

    public boolean chegouCliente() {
        if (aleatorio.nextInt(30) == 0) {
            totalClientes++;
            return true;
        }
        return false;
    }

    public int getTotalClientes() {
        return totalClientes;
    }
}

