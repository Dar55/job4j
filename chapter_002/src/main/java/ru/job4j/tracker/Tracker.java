
package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;
import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализаущий замену заявки в массиве
     * @param item новая заявка
     * @param id уникальный номер заявки, которую правим
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализаущий удаление заявки в массиве
     * @param id уникальный номер заявки, которую удаляем
     */
   public boolean delete(String id) {
       int n = 0;
       boolean result = false;
       for (int i = 0; i < position; i++) {
           if (this.items[i].getId().equals(id)) {
               System.arraycopy(this.items, i + 1, this.items, i, position - i);
               this.position = this.position - 1;
               result = true;
               break;
           }
       }
       return result;
   }
    /**
     * Поиск по имени
     * @param key имя заявки
     */
    public Item[] findByName(String key) {
        int b = 0;
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[b++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, b);
   }
    /**
     * Поиск по id
     * @param id имя заявки
     */
    public Item findById(String id) {
        Item result = null;

        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    /**
     * Поиск всех ненулевых заявок
     */
    public Item[] findAll() {
         return Arrays.copyOf(this.items, this.position);
    }
}


