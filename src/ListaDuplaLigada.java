public class ListaDuplaLigada {

    private Node firstNode;
    private Node lastNode;
    private String name;
    int size;

    public ListaDuplaLigada(String listName) {
        name = listName;
        firstNode = lastNode = null;
        size = 0;
    }

    public void insertInicio(int insertItem) {
        Node novoNo = new Node(insertItem);

        if (isEmpty())
        {
            firstNode = lastNode = novoNo;
        } else
        {
            novoNo.setNext(firstNode);
            firstNode.setPrev(novoNo);
            firstNode = novoNo;
        }
        size++;
    }

    public void insertFim(int insertItem) {
        Node novoNo = new Node(insertItem);
        if (isEmpty()) {
            firstNode = lastNode = novoNo;
        } else {
            lastNode.setNext(novoNo);
            novoNo.setPrev(lastNode);
            lastNode = novoNo;
        }
        size++;
    }

    public int removeInicio() {
        if (isEmpty())
        {
            return -1;
        }

        int removedItem = firstNode.getObject();
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode.getNext().setPrev(null);
            firstNode = firstNode.getNext();
        }
        size--;
        return removedItem;
    }

    public int removeFim() {
        if (isEmpty())
        {
            return -1;
        }

        int removedItem = lastNode.getObject();


        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            lastNode.getPrev().setNext(null);
            lastNode = lastNode.getPrev();
        }
        size--;
        return removedItem;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty " + name);
            return;
        }

        System.out.print("The " + name + " is: ");
        Node current = firstNode;

        while (current != null) {
            System.out.print("\t" + current.getObject());
            current = current.getNext();
        }
        System.out.println("\n");
    }

    public void inserePosicao(int pos, int valor){
        if(pos <= 0)
            System.out.println("A primeira posicao eh a 1. Inserir uma posicao existente!");
        else{
            if(pos == 1)
                insertInicio(valor);
            else{
                if(pos > size)
                    insertFim(valor);
                else{
                    Node novoNo = new Node(valor);
                    Node temp = firstNode;
                    for(int i=1; i<pos; i++)
                        temp = temp.getNext();
                    temp.getPrev().setNext(novoNo);
                    novoNo.setPrev(temp.getPrev());
                    novoNo.setNext(temp);
                    temp.setPrev(novoNo);

                    size++;
                }
            }
        }
    }

    public int removePosicao(int pos){
        if(pos <= 0){
            System.out.println("A primeira posicao eh a 1. Inserir uma posicao existente!");
            return -1;
        }else{
            if(pos == 1)
                return removeInicio();
            else{
                if(pos >= size)
                    return removeFim();
                else{
                    int valorRemovido;
                    Node temp = firstNode;
                    for(int i=1; i<pos; i++)
                        temp = temp.getNext();
                    valorRemovido = temp.getObject();
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());

                    size--;
                    return valorRemovido;

                }
            }
        }

    }
}
