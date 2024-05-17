public class FilaCliente {
    private No inicio, fim;

    public FilaCliente() {
        inicio = null;      //Fila vazia
        fim = null;
    }

    public boolean isEmpty()       // true se a Fila está vazia
    {
        return (inicio == null);
    }

    public void enqueue(int horaDeEntrada) // insere no fim da fila
    {
        No newNo = new No(horaDeEntrada);

        if (inicio == null) {
            inicio = newNo;
            fim = inicio;
        } else {
            fim.next = newNo;
            fim = newNo;
        }
    }

    public int dequeue()      // remove do inicio da fila
    {
        if (isEmpty())      //se estiver vazia retorna -1
            return -1;

        No temp = inicio;           // utilizado para retornar o dado
        inicio = inicio.next;         // move o topo para o prox nó
        if (inicio == null)
            fim = null;
        return temp.clientes.getHoraDeEntrada();        // retorna o dado
    }

}