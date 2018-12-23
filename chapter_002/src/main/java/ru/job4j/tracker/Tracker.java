
package ru.job4j.tracker;
import  ru.job4j.tracker.models.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */

    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    public void replace(String id, Item item){

    }
    public void delete(String id){

    }
    public Item[] findAll(){

      return {0,1,2,3};
    }
    public Item[] findByName(String key){
        return {0};
    }
    public Item findById(String id){
        return "a";
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        
        //Реализовать метод генерации.
        return Math.random();
    }
}