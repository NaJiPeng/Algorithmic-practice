package linear_list;

import java.util.Random;

public class MyArrayList<T> implements LinearList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] array;

    private int size = 0;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
    }

    private void checkIndex(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increase() {
        System.out.println("increase:" + array.length + "to" + array.length * 2);
        Object[] preArray = array;
        array = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            array[i] = preArray[i];
        }
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    @Override
    public void insert(int index, T element) {
        checkIndex(index);

        if (array.length == size) {
            increase();
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
    }

    @Override
    public void add(T element) {
        if (array.length == size) {
            increase();
        }

        array[size++] = element;
    }

    @Override
    public void delete(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
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

        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Math.abs(new Random().nextInt() % 10));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i == 0 ? "" : ",") + list.get(i));
        }

        for (int i = 0; i < 5; i++) {
            list.insert(5,-1);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i == 0 ? "" : ",") + list.get(i));
        }

        for (int i = 0; i < 3; i++) {
            list.delete(1);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i == 0 ? "" : ",") + list.get(i));
        }

        System.out.println("empty:"+list.isEmpty());
        list.clear();
        System.out.println("empty:"+list.isEmpty());

    }

}
