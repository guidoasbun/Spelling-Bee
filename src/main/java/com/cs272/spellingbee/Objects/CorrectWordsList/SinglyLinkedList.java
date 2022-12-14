// Programmer: Guido Asbun

package com.cs272.spellingbee.Objects.CorrectWordsList;

import javafx.scene.control.ListView;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    // Instance Variables
    private int size;
    private SinglyLinkedListNode<E> head = null;
    private SinglyLinkedListNode<E> tail = null;

    // Constructor
    public SinglyLinkedList() {
        size = 0;
    }

    // Methods
    public void addLast(E element) {
        SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<>(element, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
        size++;
    }

    public int getSize() {
        return (size);
    }

    public int occurrences(E element) {
        int count = 0;
        SinglyLinkedListNode<E> currentNode = head;
        for (int index = 0; index < size; index++) {
            if (currentNode.getElement().equals(element)) {
                count++;
            }
            currentNode = currentNode.getNextNode();
        }
        return (count);
    }

    public void getCorrectWordListView(ListView<String> correctWordsListView ) {
        SinglyLinkedListNode<E> currentNode = head;
        for (int index = 0; index < size; index++) {
            correctWordsListView.getItems().addAll((String) currentNode.getElement());
            currentNode = currentNode.getNextNode();
        }
        correctWordsListView.getSelectionModel().select(-1);
    }

    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
