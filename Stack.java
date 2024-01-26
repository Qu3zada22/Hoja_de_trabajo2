import java.util.LinkedList;

public class Stack<T> implements UVGStack<T> {
    private LinkedList<T> stackList;

    public Stack() {
        stackList = new LinkedList<>();
    }

    @Override
    public void push(T x) {
        stackList.addFirst(x);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.removeFirst();
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}
