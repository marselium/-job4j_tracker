package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "RandomName")) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
            }
        }

    public User findByPassport(String passport) {
        User search  = null;
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                search = user;
                break;
            }
        }
        return search;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account founded = null;
        User user = findByPassport(passport);
        if (user != null) {
           List<Account> accounts = users.get(user);
            for (Account search : accounts) {
                if (search.getRequisite().equals(requisite)) {
                    founded = search;
                    break;
                }
            }
        }
        return founded;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account first = findByRequisite(srcPassport, srcRequisite);
        Account second = findByRequisite(destPassport, destRequisite);
        if (first != null && second != null && first.getBalance() >= amount) {
            double srcBalance = first.getBalance();
            first.setBalance(srcBalance - amount);
            double destBalance = second.getBalance();
            second.setBalance(destBalance + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}