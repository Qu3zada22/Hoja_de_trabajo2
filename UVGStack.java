public interface UVGStack<T> {
    void push(T x);

    T pop();

    T top();

    boolean isEmpty();
}
