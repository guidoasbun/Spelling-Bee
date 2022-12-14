// Programmer: Guido Asbun

package com.cs272.spellingbee.Objects.CorrectWordsList;

public class SinglyLinkedListNode<E> {
    // INSTANCE VARIABLES
    private final E element;
    private SinglyLinkedListNode<E> nextNode;

    // CONSTRUCTORS
    public SinglyLinkedListNode(E element, SinglyLinkedListNode<E> nextNode)
    {
        this.element = element;
        this.nextNode = nextNode;
    }

    // INSTANCE METHODS
    public E getElement()
    {
        return element;
    }

    public void setNextNode(SinglyLinkedListNode<E> nextNode)
    {
        this.nextNode = nextNode;
    }

    public SinglyLinkedListNode<E> getNextNode()
    {
        return nextNode;
    }
}