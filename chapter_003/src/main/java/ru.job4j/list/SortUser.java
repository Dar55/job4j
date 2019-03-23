package ru.job4j.list;

import java.util.*;

public class SortUser {


    public Set<User> set(List listUsers) {
        Set<User> users = new TreeSet<>();

        users.addAll(listUsers);
        //      );
        //       for (User s : users)
        //       {
//            System.out.println(s.getName() + "   " + s.getAge());
//        }
        return users;
    }

    public List<User> sortNameLength(List<User> bum) {
        List<User> users = new ArrayList<>();
        users.addAll(bum);
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> bum) {
        List<User> users = new ArrayList<>();
        users.addAll(bum);
        users.sort(new Comparator<User>() {
            int result =0;
            @Override
            public int compare(User o1, User o2) {
                result = o1.getName().compareTo(o2.getName());

                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        return users;
    }
}

