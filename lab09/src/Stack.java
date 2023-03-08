public class Stack<T extends Comparable<T>> {

    private T[] stack;
    private int howMany = 0;

    public Stack() {
        stack = (T[]) new Comparable[5];
    }

    public Stack(int size) {
        stack = (T[]) new Comparable[size];
    }

    public void push(T item) throws StackException {
        if(stack.length==howMany) throw new StackException(stack.length);
        else stack[howMany++] = item;
    }

    public T pop() throws StackException {
        if(howMany==0) throw new StackException(stack.length);
        else return stack[--howMany];
    }

}
