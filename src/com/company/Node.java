package com.company;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Node {
    private final int id;
    private final int[] start;
    private final int[][] interval;
    private final int[] successor;
    private int predecessor;

    public Node(int id, Node[] list) {
        this.id = id;
        int m = (int) (log(list.length) / log(2));
        this.start = new int[m];
        this.interval = new int[m][2];
        this.successor = new int[m];
        for (int i = 0; i < start.length; i++) {
            start[i] = (int) ((id + pow(2, i)) % (pow(2, start.length)));
        }
        for (int i = 0; i < start.length; i++) {
            interval[i][0] = start[i];
            interval[i][1] = (int) ((id + pow(2, i + 1)) % (pow(2, start.length)));
            boolean flag2 = true;                   // флаг: если в интервале нет саксессора, то проходим весь chordNode
            // от current Node и присваиваем саксессору ближайший встретившийся нод
            if (interval[i][1] > interval[i][0]) {  // иф: возможно 2 ситуации: интервал от меньшего к большему (2;5) ->
                for (int j = interval[i][0]; j <= interval[i][1]; j++) {
                    if (list[j] != null) {
                        successor[i] = list[j].getId();
                        flag2 = false;
                        break;
                    }
                }
            } else {                                // -> и от большего к меньшему (6;2)
                boolean flag = true;                // фор: так как не можем пройти все элементы от 6 до 2 по возрастанию
                // (6 -> 7 -> 0 -> 1 -> 2), то пройдём от большего до конца (6 -> 7) и от начала до меньшего (0 -> 1 -> 2)
                for (int j = interval[i][0]; j < list.length; j++) {
                    if (list[j] != null) {
                        successor[i] = list[j].getId();
                        flag = false;               // флаг: если в первой половине нашелся саксессор, то вторую половину
                        // принудительно не проверяем
                        flag2 = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j <= interval[i][1]; j++) {
                        if (list[j] != null) {
                            successor[i] = list[j].getId();
                            flag2 = false;
                            break;
                        }
                    }
                }
            }
            if (flag2) {                            // если не нашли саксессор в заданных интервалах, примем за саксессор
                // первый же Node, который встретится после текущего.
                boolean flag3 = true;
                for (int j = id + 1; j < list.length; j++) {
                    if (list[j] != null) {
                        successor[i] = list[j].getId();
                        flag3 = false;
                        break;
                    }
                }
                if (flag3) {
                    for (int j = 0; j <= id; j++) {
                        if (list[j] != null) {
                            successor[i] = list[j].getId();
                            break;
                        }
                    }
                }
            }
        }
        boolean flag4 = true;                       // флаг: очередная проверка: так как идём в обратном порядке, то сначала
        // доходим от current - 1 до 0, а потом от 0 до current. Если в первой половине нашли предексессор, то останавливаем поиск.
        // Если не нашли - ведём поиск во второй половине
        for (int i = id - 1; i >= 0; i--) {
            if (list[i] != null) {
                predecessor = list[i].getId();
                flag4 = false;
                break;
            }
        }
        if (flag4) {
            for (int i = list.length - 1; i >= id; i--) {
                if (list[i] != null) {
                    predecessor = list[i].getId();
                    break;
                }
            }
        }
    }

    public Node getNode() {
        return this;
    }

    public int getId() {
        return id;
    }

    public int[] getStart() {
        return start;
    }

    public int[][] getInterval() {
        return interval;
    }

    public int[] getSuccessor() {
        return successor;
    }

    public int getPredecessor() {
        return predecessor;
    }

}
