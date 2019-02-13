package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
        System.out.println(persons.get(0));
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person pers : persons) {
            if ((pers.getName() == key)|(pers.getAddress() == key)|(pers.getPhone() == key)|(pers.getSurname() == key)){
                result.add(pers);
            }
        }
        return result;
    }
}