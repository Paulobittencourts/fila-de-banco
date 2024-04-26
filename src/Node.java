public class Node {


    private int data;
    private Node nextNode;
    private Node prevNode;

    public Node(int object) {
        this(object, null, null);
    }

    public Node(int object, Node next, Node prev) {
        data = object;
        nextNode = next;
        prevNode = prev;
    }

    public int getObject() {
        return data;
    }

    public Node getNext() {
        return nextNode;
    }

    public Node getPrev() {
        return prevNode;
    }

    public void setObject(int object) {
        data = object;
    }

    public void setNext(Node next) {
        nextNode = next;
    }

    public void setPrev(Node prev) {
        prevNode = prev;
    }
}
