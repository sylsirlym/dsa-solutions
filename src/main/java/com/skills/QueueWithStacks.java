package com.skills;

import java.util.Stack;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 17:30
 */
public class QueueWithStacks<T> {
    private final Stack<T> stackNewestOnTop = new Stack<>();
    private final Stack<T> stackOldestOnTop = new Stack<>();

    public void enqueue(T value){
        stackNewestOnTop.push(value);
    }

    //Get oldest item
    public T peek(){
        shiftItems();
        return stackOldestOnTop.peek();
    }

    //Remove oldest item
    public T dequeue(){
        shiftItems();
        return stackOldestOnTop.pop();
    }

    //Shift from stackNewestOnTop only when stackOldestOnTop is empty
    private void shiftItems() {
        if(stackOldestOnTop.isEmpty()){
            while(!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }

    public boolean isEmpty() {
        return stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty();
    }
}
