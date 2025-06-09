package com.skills;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 19:38
 */
public class StackImpl {
    public class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek(){
        return top.data;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
    }

    public int pop() {
        int data = top.data;
        top=top.next;
        return data;
    }
}
