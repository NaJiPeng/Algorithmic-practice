package linear_list;

public class MyLinkedList<T> implements LinearList<T> {

    private class Node<T> {

        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        Node() {
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int size = 0;
    private Node<T> head = new Node<>();

    @Override
    public int indexOf(T element) {
        int i = 0;
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
            if (node.data == element) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        int i = 0;
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
            if (i == index) {
                return node.data;
            }
            i++;
        }
        return null;
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        int i = 0;
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
            if (i == index) {
                node.data = element;
            }
        }
    }

    @Override
    public void insert(int index, T element) {
        checkIndex(index);
        int i = -1;
        Node<T> node = head;
        while (node.next != null) {
            if (i == index - 1) {
                Node<T> elementNode = new Node<>(element, node.next);
                node.next = elementNode;
                size++;
            }
            node = node.next;
            i++;
        }
    }

    @Override
    public void add(T element) {
        Node<T> node = head;
        while (node.next != null) node = node.next;
        node.next = new Node<>(element, null);
        size++;
    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        int i = -1;
        Node<T> node = head;
        while (node.next != null) {
            if (i == index - 1) {
                node.next = node.next.next;
                size--;
            }
            node = node.next;
            i++;
        }
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nsize:" + list.size + "");

        list.insert(1, 100);

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nsize:" + list.size + "");

        list.delete(5);

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nsize:" + list.size + "");

        list.clear();
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nsize:" + list.size + "");

    }


}
