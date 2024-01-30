package effectivejava.chapter2.item7;
import java.util.*;

/**
 * 避免内存泄漏
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 程序自己管理对象,就会可能导致内存的泄漏
     */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        // 数组中虽然弹出了对象,但是对于JVM类说并不清楚,所以JVM不会对该对象进行回收
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
          // 解决的办法很简单: 在程序中不在使用某个对象时,就把引用设为null,此时JVM就会知道要回收该对象
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}
