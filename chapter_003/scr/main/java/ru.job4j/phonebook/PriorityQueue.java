package ru.job4j.phonebook;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Integer> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
      //  tasks.add(task.getPriority(), task.getDesc());
    }

    public Integer take() {
        return this.tasks.poll();
    }
}