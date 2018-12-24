
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
        for (int i = 0;i < items.length;i++ ) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                break;
            }
            i++;
        }

    }
   public void delete(String id){
       int n = 0;
       for (int i = 0;i < items.length;i++ ) {
           if (this.items[i] != null && this.items[i].getId().equals(id)) {
               n = 1;
           }
           if((n == 1) && (i == items.length - 2)){
               this.items[i] = this.items[i + 1];
           }
           i++;
       }
       if(n == 1){
           System.arraycopy(this.items, 1, this.items, 0, items.length-1);
       }
   }

    public Item findByName(String key){
        Item result = null;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result = item;
            }
        }
        return result;
   }
   //item != null &&
    public Item findById(String id) {
        Item result = null;

        for (Item item : items) {
            System.out.println(item.getId());
            if (item != null && item.getId().equals(id)) {
                result = item;
                System.out.println(result);
                break;
            }
        }
        //System.out.println(result);
        return result;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position;index++){
            result[index] = this.items[index];
        }
        return result;
    }
}


