// Programmer: Guido Asbun

package com.cs272.spellingbee.Objects.GameVariables;

import java.util.Objects;

public class StringChainHashSet {
    // Instance Variables
    private final int numberOfBuckets;
    private final StringChainHashSetNode[] bucket;

    // Constructor
    public StringChainHashSet() {
        this.numberOfBuckets = 20;
        this.bucket = new StringChainHashSetNode[this.numberOfBuckets];
    }

    // Private Methods
    private int hashCodeIndex(String element) {
        int hashCode = Math.abs(element.hashCode());
        return (hashCode % this.numberOfBuckets);
    }

    // Public Methods
    public boolean add(String element) {
        int index = hashCodeIndex(element);
        StringChainHashSetNode currentNode = this.bucket[index];
        while (currentNode != null) {
            if (Objects.equals(currentNode.getElement(), element)) {
                return false;
            }
            currentNode = currentNode.getNextNode();
        }
        StringChainHashSetNode newNode = new StringChainHashSetNode(element, this.bucket[index]);
        this.bucket[index] = newNode;
        return true;
    }

    public boolean contains(String element) {
        int index = hashCodeIndex(element);
        StringChainHashSetNode currentNode = this.bucket[index];
        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }
}
