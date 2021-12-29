package com.lht.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Leo
 * @date 2021/12/27
 *
 * 这里由于是一个Demo，所以需要给栈指定容量。
 * 一个工业级的Stack是不需要指定容量的，可以参考JAVA的Deque实现。
 * 它会在初始时指定容量，然后当容量过大的时候，会自动扩容。这个行为用户是毫无感知的。
 *
 */
public class ArrayStack<T> {

    private Object[] items;
    private int top;//栈顶元素所在位置
    private int size;//栈的容量

    public static void main(String[] args) throws Exception {

        ArrayStack<Integer> myStack = new ArrayStack<>(3);
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());


    }

    public ArrayStack(int size) {
        this.size = size;
        top = -1;
        this.items = new Object[size];
    }

    public void push(T t) throws Exception {
        if (isFull()) {
            throw new Exception("stack is full,can't add element");
        }
        items[++top] = t;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty,can't get element");
        }
        T element = (T) items[top--];
        return element;
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty,can't get element");
        }
        T element = (T) items[top];
        return element;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }


}
