public class No {
    public Clientes clientes;
    public No next;

    public No(int horaDeEntrada) {
        clientes = new Clientes(horaDeEntrada);
        next = null;
    }
}