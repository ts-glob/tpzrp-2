package com.company;

public class Main {
    public static void main(String[] args) {
        ChordNode chordNode = new ChordNode(8);
        chordNode.addNode(0);
        chordNode.addNode(3);
        chordNode.addNode(6);
        chordNode.addNode(6);
        chordNode.addNode(1);
        chordNode.addNode(28);
        chordNode.addNode(-3);
        chordNode.removeNode(6);
        chordNode.removeNode(6);
        chordNode.printList();
        chordNode.printNodes();
    }
}
