import java.util.Random;

public class Clientes {

    private int horaDeEntrada;
    private final Random aleatorio = new Random();
    private int totalClientes = 0;
    private FilaCliente clienteFila = new FilaCliente();

    public Clientes() {
    }

    public Clientes(int horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public boolean chegouCliente(int tempo) {
        if (aleatorio.nextInt(30) == 0) {
            clienteFila.enqueue(tempo);
            totalClientes++;
            return true;
        }
        return false;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public int getHoraDeEntrada() {
        return horaDeEntrada;
    }
}


