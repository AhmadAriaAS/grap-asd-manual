package LinkedList;

public class Node<T> {
    T data;
    Node<T> prev, next;

    Node(Node<T> prev, T data, Node<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
