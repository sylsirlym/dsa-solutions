package com.skills;


/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 19:11
 */
public class QueueImpl {
    public class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek(){
        return head.data;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if(tail!=null){
            tail.next = newNode; //Update the current tail's next to our new node
        }
        tail = newNode; //Update tail
        if(head==null){
            head = newNode; // If empty, set new Node as head
        }
    }

    public int remove() {
        int data = head.data;//Set the data for head
        Node oldHead = head; // Create oldHead
        head = head.next; //Point head to next head
        oldHead.next = null; // Clear reference to help GC
        //If head is null, set tail to null as well
        if(head==null){
            tail = null;
        }
        return data;
    }
}
