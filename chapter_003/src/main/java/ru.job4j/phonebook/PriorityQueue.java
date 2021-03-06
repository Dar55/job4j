package ru.job4j.phonebook;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (tasks.peekFirst() != null) {
            for (Task tat : tasks) {
                if (tat.getPriority() > task.getPriority()) {
                    break;
                }
            index++;
            }
        }
        tasks.add(index, task);
        }

    public Task take() {
        return this.tasks.poll();
    }
}