/* Problem set 6 - Problem 1

Name: Jose Ramos
Date: November 9, 2019

-- OBJECTIVE --

Implement the books queue interface on an array-based queue and on a linked queue. Add the following methods to both your queue implementations and provide a test file.

* swapFront() - swaps the first two elements in the queue, returns true if successful, false otherwise (like only 1 element in the queue)
* swapBack( )- swaps the last two elements in the queue,  returns true if successful, false otherwise (like only 1 element in the queue)
* remove (int i) - takes the index of an element in the queue and returns it. Returns a boolean value - true if the item is removed, false otherwise (like an invalid index)
* toString() - provide a toString method that prints the queues contents clearly.
* count() - a method that returns the number of elements in the queue - it must recursively count the elements. You cannot use a instance variable to track the count.

Reference: - OpenDSA Chapter 9.2 Linked Queues & Chapter 9.1 Queues
*/

class AQueue<E> implements Queue<E> {
    private E queueArray[];      // Array holding queue elements
    private static final int DEFAULT_SIZE = 10;
    private int maxSize;         // Maximum size of queue
    private int front;           // Index of front element
    private int rear;            // Index of rear element

    // Constructors
    @SuppressWarnings("unchecked") // Generic array allocation
    AQueue(int size) {
        maxSize = size+1;          // One extra space is allocated
        rear = 0; front = 1;
        queueArray = (E[])new Object[maxSize];  // Create queueArray
    }
    AQueue() { this(DEFAULT_SIZE); }

    // Reinitialize
    public void clear() { rear = 0; front = 1; }

    // Put "it" in queue
    public boolean enqueue(E it) {
        if (((rear+2) % maxSize) == front) return false;  // Full
        rear = (rear+1) % maxSize; // Circular increment
        queueArray[rear] = it;
        return true;
    }

    // Remove and return front value
    public E dequeue() {
        if(length() == 0) return null;
        E it = queueArray[front];
        front = (front+1) % maxSize; // Circular increment
        return it;
    }

    // Return front value
    public E frontValue() {
        if (length() == 0) return null;
        return queueArray[front];
    }

    // Return queue size
    public int length() { return ((rear+maxSize) - front + 1) % maxSize; }

    //Tell if the queue is empty or not
    public boolean isEmpty() { return front - rear == 1; }

    public String toString(){

        int size = length();

        if(size == 0){ return "Front --> [ ] <-- Rear";}

        StringBuffer out = new StringBuffer((maxSize + 1) * 4);

        out.append("Front --> [ ");

        for (int i = 0; i < size; i++) {
            out.append(queueArray[(front + i)%(maxSize)]);
            out.append(" ");

        }
        out.append("] <-- Rear");

        return out.toString();
    }

    public boolean swapFront(){

        if(length() <= 1){return false;}

        E temp = queueArray[front];
        queueArray[front] = queueArray[(front+1)%maxSize];
        queueArray[(front+1)%maxSize] = temp;

        return true;
    }

    public boolean swapBack(){
        if(length() <= 1){return false;}

        E temp = queueArray[rear];

        if(rear == 0){
            queueArray[rear] = queueArray[maxSize - 1];
            queueArray[maxSize - 1] = temp;
        }
        else{
            queueArray[rear] = queueArray[rear - 1];
            queueArray[rear - 1] = temp;
        }

        return true;
    }

    // Here I used the bubble method to put the given index to the front and then dequeue
    public boolean remove (int i){

        int size = length();

        if(i >= size || i < 0){return false;}

        // Bubble method to put the given index to the front
        for(int n = i; n > 0; n--){
            E temp = queueArray[(front + n - 1)%maxSize];
            queueArray[(front + n - 1)%maxSize] = queueArray[(front + n)%maxSize];
            queueArray[(front + n)%maxSize] = temp;
        }
        dequeue();

        return true;
    }

    private int count(int i){

        if(i == rear){
            return 1;
        }
        else{
            i = (i+1)% maxSize;
            return 1 + count(i);
        }
    }

    public int count(){
        return count(front);
    }

}