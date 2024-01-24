import java.util.Arrays;

public class VectorStack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public VectorStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(E element) {
        ensureCapacity();
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La fila está vacía");
        }
        E element = (E) array[--size];
        array[size] = null;  // Limpiar la posición de memoria
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
    }
}
