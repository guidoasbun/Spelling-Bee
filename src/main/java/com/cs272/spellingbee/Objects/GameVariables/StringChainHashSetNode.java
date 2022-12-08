package com.cs272.spellingbee.Objects.GameVariables;

public class StringChainHashSetNode {
    // Instance variables
    private final String element;
    private StringChainHashSetNode nextNode;

    // Constructor
    public StringChainHashSetNode(String element, StringChainHashSetNode nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    // Methods
    public String getElement() {
        return element;
    }

    public StringChainHashSetNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StringChainHashSetNode nextNode) {
        this.nextNode = nextNode;
    }
}
