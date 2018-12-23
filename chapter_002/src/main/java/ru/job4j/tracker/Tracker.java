
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
    public void replace(String id, Item item){
        int i = 0;
        for (Item itemAm : items) {
            if (itemAm != null && itemAm.getId().equals(id)) {
                this.items[i] = item;
                break;
            }
            i++;
        }

    }
   public void delete(String id){
       int i = 0;
       int n = 0;
       for (Item itemAm : items) {
           if (itemAm != null && itemAm.getId().equals(id)) {
               n = 1;
           }
           if (n == 1) {
               this.items[i] = this.items[i+1];
           }
           i++;
   }
  //  public  findAll(String id){

  //  }
  //  public findByName(String id){
//
   // }
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                item.
                break;
            }
        }
            return result;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position;index++){
            result[index] = this.items[index];
        }
        return result;
    }
}


