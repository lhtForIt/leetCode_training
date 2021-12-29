package com.lht.leetcode;

/**
 * @author lianght1
 * @date 2021/12/27
 *
 * 链式栈里面没有长度的概念，因此不需要
 * 判定是否满，但是需要判空
 *
 *
 */
public class LinkedStack<T> {

    ListNode head;

    public static void main(String[] args) throws Throwable {
        LinkedStack<Integer> myStack = new LinkedStack<>();
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public void push(T e) {
        if (head == null) {
            head = new ListNode(null, e);
        } else {
            head = new ListNode(head, e);
        }
    }


    public T pop() throws Throwable {
        if (isEmpty()) {
            throw new Throwable("stack is empty,can't add element");
        }
        T e = head.val;
        head = head.next;
        return e;
    }

    public T peek() throws Throwable {
        if (isEmpty()) {
            throw new Throwable("stack is empty,can't add element");
        }
        T e = head.val;
        return e;
    }

    public boolean isEmpty(){
        return head == null;
    }




    class ListNode{

        private ListNode next;
        private T val;

        public ListNode(ListNode next, T val) {
            this.next = next;
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }
    }












}
