package com.company;

import java.util.Arrays;

import static com.company.DictionaryErrors.*;

public class ChordNode {
    private Node nodeList[];
    private int len;

    public ChordNode(int n) {
        len = n;
        nodeList = new Node[n];
        new DictionaryErrors();
    }

    public void addNode(int id) {
        if (id >= len) {
            System.out.println(errorMessage(0));
            return;
        }
        if (id < 0) {
            System.out.println(errorMessage(1));
            return;
        }
        if (nodeList[id] == null) {
            nodeList[id] = new Node(id, nodeList);
            System.out.println("Добавлен узел " + id);
            updateNodes();
        } else {
            System.out.println(errorMessage(2, id));
        }
    }

    public void removeNode(int id) {
        if (nodeList[id] != null) {
            nodeList[id] = null;
            System.out.println("Узел " + id + " удалён");
            updateNodes();
        } else {
            System.out.println(errorMessage(3, id));
        }

    }

    public void updateNodes() {
        for (int i = 0; i < len; i++) {
            if (nodeList[i] != null) {
                nodeList[i] = new Node(i, nodeList);
            }
        }
    }


    public void printList() {
        for (int i = 0; i < len; i++) {
            if (nodeList[i] == null) {
                if (i == len - 1) {
                    System.out.println(errorMessage(4));
                    return;
                }
            }
        }
        System.out.println("\nСПИСОК УЗЛОВ");
        for (int i = 0; i < len; i++)
            if (nodeList[i] != null)
                System.out.println("Узел " + nodeList[i].getId() + " в сети");
        System.out.print("\n");
    }

    public void printNodes() {
        for (int i = 0; i < len; i++) {
            if (nodeList[i] != null) {
                Node currentNode = nodeList[i].getNode();
                System.out.println("Номер узла: " + currentNode.getId());
                System.out.println("start: " + Arrays.toString(currentNode.getStart()));
                System.out.print("interval: ");
                for (int j = 0; j < currentNode.getInterval().length; j++) {
                    System.out.print(Arrays.toString(currentNode.getInterval()[j]) + "; ");
                }
                System.out.println("\nsuccessor: " + Arrays.toString(currentNode.getSuccessor()));
                System.out.println("predecessor: " + currentNode.getPredecessor() + "\n");
            }
        }
    }
}
