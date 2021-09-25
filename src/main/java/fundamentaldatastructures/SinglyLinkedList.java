package fundamentaldatastructures;

import java.util.LinkedList;
import java.util.List;
/*A linked list is a collection of nodes that collectively form
a linear sequence. In a singly linked list,
each node stores a reference to an object that is an
element of the sequence, as well as a reference to the
next node of the list*/
public class SinglyLinkedList<E> implements Cloneable {
    private static class Node<E>{
        private final E element;// reference to the element stored at this node
        private Node<E> next;// reference to the subsequent node in the list

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    // access methods
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){// returns (but does not remove) the first element
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }

    public E last(){// returns (but does not remove) the last element
        if(isEmpty()){
            return null;
        }

        return tail.getElement();
    }

    //update methods
    public void addFirst(E e){// adds element e to the front of the list
        head = new Node<>(e, head);// create and link a new node
        if(size == 0){
            tail = head;// special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e){// adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);// node will eventually be the tail
        if(isEmpty()){
            head = newest;// special case: previously empty list
        }else{
            tail.setNext(newest);// new node after existing tail
        }
        tail = newest;// new node becomes the tail
        size++;
    }

    public E removeFirst(){// removes and returns the first element
        if(isEmpty()){// nothing to remove
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();// will become null if list had only one node
        size--;

        if(size == 0){
            tail = null;// special case as list is now empty
        }

        return answer;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(getClass() != o.getClass()){
            return false;
        }

        SinglyLinkedList other = (SinglyLinkedList) o;// use nonparameterized type
        if(size != other.size()){
            return false;
        }

        Node walkA = head;// traverse the primary list
        Node walkB = other.head;// traverse the secondary list

        while (walkA != null){
            if(!walkA.getElement().equals(walkB.getElement())){//mismatch
                return false;
            }
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;// if we reach this, everything matched successfully
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if(size > 0){
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while(walk != null){
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }
}
