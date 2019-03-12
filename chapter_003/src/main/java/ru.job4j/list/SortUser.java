package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {



    public Set<User> set (List listUsers) {
        Set<User> users = new TreeSet<>();

        users.addAll(listUsers);
  //      );
 //       for (User s : users)
 //       {
//            System.out.println(s.getName() + "   " + s.getAge());
//        }
        return users;
    }
}
