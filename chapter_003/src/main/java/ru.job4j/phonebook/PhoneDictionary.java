package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if ((pers.getName().equals(key))||(pers.getAddress().equals(key))||(pers.getPhone().equals(key))||(pers.getSurname().equals(key))){
                result.add(pers);
            }
        }
        return result;
    }
}