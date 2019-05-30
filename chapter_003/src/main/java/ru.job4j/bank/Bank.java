package ru.job4j.bank;


import java.util.*;
//import java.util.TreeMap;


public class Bank {

    private HashMap<User, ArrayList<Account>> treemap = new HashMap<>();


    public void addUser(User user) {
        if (this.treemap.get(user) == null){
            this.treemap.put(user, new ArrayList<>());
        }
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccount(User user, Account account) {
        if (this.treemap.get(user) != null && !this.treemap.get(user).contains(account)) {
            this.treemap.get(user).add(account);
            System.out.println("аккаунт добавлен");
        }
    }

 //   private Account getActualAccount(User user, Account account) {
 //       ArrayList<Account> list = this.treemap.get(user);
 //       return list.get(list.indexOf(account));
  //  }

    public void deleteAccount(User user, Account account) {
        if (this.treemap.get(user) != null) {
            this.treemap.get(user).remove(account);
        }
    }

    public List<Account> getAccounts(User user) {
        if (this.treemap.get(user) != null) {
            return this.treemap.get(user);
        } else {
            return  Collections.emptyList();
        }
    }

    public Account FindAccount(String passport, String requisites) {

        Account result = null;
        for (User us: treemap.keySet()) {
            if (passport.equals(us.getpassport())) {
               for (Account acc : this.treemap.get(us)) {
                   if (requisites.equals(acc.getReqs())) {
                       result = acc;
                       break;
                   }
               }
               break;
            }
        }
        return result;
    }

 //   public boolean transfer(User user1, Account account1,
 //                               User user2, Account account2, double amount) {
//
 //       return this.treemap.get(user1).contains(account1)
//                && this.treemap.get(user2).contains(account2)
 //               && getActualAccount(user1, account1).transfer(
  //              getActualAccount(user2, account2), amount);
  //  }

    public boolean transfer(String passport1, String requisites1,
                            String passport2, String requisites2, double amount) {

        boolean result = false;
        Account account1 = FindAccount(passport1,requisites1);
        Account account2 = FindAccount(passport2,requisites2);
        if (account1 != null && account2 != null) {
            account1.transfer(account2, amount);
            result = true;
        }
        return result;
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}