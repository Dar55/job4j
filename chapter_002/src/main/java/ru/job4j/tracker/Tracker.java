
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
    //private final Item[] items = new Item[100];
    List<Item> items = new ArrayList<>();
   // private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    /**
     * Метод реализаущий замену заявки в массиве
     * @param item новая заявка
     * @param id уникальный номер заявки, которую правим
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
       // boolean  result = this.delete(id);
        boolean result = false;
   //     int res = items.indexOf(item);
   //     if (res != -1) {
    //        this.items.set(res,item);
    //        result = true;
   //     }

        for (int i = 0; i<items.size();i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                result = true;
            }
 //       Iterator<Item> itemIterator = items.iterator();
//        while (itemIterator.hasNext()) {
//
//            Item nextItem = itemIterator.next();
 //           if (nextItem.getId().equals(id)) {
 //               this.items.set(itemIter.)
 //             //  itemIterator.remove();
 //               result = true;
 //           }

        }
        return result;
    }
    /**
     * Метод реализаущий удаление заявки в массиве
     * @param id уникальный номер заявки, которую удаляем
     */
   public boolean delete(String id) {
       boolean result = false;
       int i = 0;
       for (Item it:items) {
           if (it.getId().equals(id)) {
               result = true;
               break;
           }
           i++;
       }
       if (result) items.remove(i);
//      Iterator<Item> itemIterator = items.iterator();
//       while (itemIterator.hasNext()) {

//           Item nextItem = itemIterator.next();
//           if (nextItem.getId().equals(id)) {
//               itemIterator.remove();
//               result = true;
//           }

 //      }
       return result;
   }
    /**
     * Поиск по имени
     * @param key имя заявки
     */
    public List findByName(String key) {
        List<Item> itemsReturn = new ArrayList<>();
        for (Item it:items) {
            if (it.getName().equals(key)) {
                itemsReturn.add(it);
            }
        }
        return itemsReturn;
   }
    /**
     * Поиск по id
     * @param id имя заявки
     */
    public Item findById(String id) {
        Item result = null;
        Iterator<Item> itemIterator = items.iterator();
        while (itemIterator.hasNext()) {

            Item nextItem = itemIterator.next();
            if (nextItem.getId().equals(id)) {
                result = nextItem;
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
    public List findAll() {
        return items;
    }
}


