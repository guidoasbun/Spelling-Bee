package com.cs272.spellingbee.Objects.GameVariables;

import java.util.Objects;

public class StringChainHashSet {
    // Instance Variables
    private final int numberOfBuckets;
    private int size;
    private final StringChainHashSetNode[] bucket;

    // Constructor
    public StringChainHashSet() {
        this.numberOfBuckets = 20;
        this.size = 0;
        this.bucket = new StringChainHashSetNode[this.numberOfBuckets];
    }

    public StringChainHashSet(int numberOfBuckets) {
        if (numberOfBuckets <= 0) {
            throw new IllegalArgumentException("Number of buckets must be >= 1");
        } else {
            this.numberOfBuckets = numberOfBuckets;
            this.size = 0;
            this.bucket = new StringChainHashSetNode[this.numberOfBuckets];
        }
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
        this.size++;
        return true;
    }

    public int getSize() {
        return this.size;
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
