package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;
/**
 * Класс, в котором описаны методы для работы с пользователями и
 * их счетами внутри банковской системы
* @author MARSEL YUMAGULOV
* @version 1.0
*/
public class BankService {
    /**
     * Поле, в которое записываются все клиенты и их счета
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления пользователя в систему
     * @param user Создаёт уникального пользователя, если клиента с таким ключом ещё нет в системе
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод для удаления пользователя из системы
     * @param passport паспорт клиета-его уникальный ключ, т.е. идентификатор клиента
     * @return служит для указания статуса операции: true, если пользователь удалён, false, если нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "RandomName")) != null;
    }

    /**
     * Метод для добавления нового счёта пользователю
     * @param passport паспорт клиета-его уникальный ключ
     * @param account номер счёта. Также уникален
     *Если паспорт пользователя найден, добавляет новый счёт при условии
     *                                          отстуствия счёта с таким же номером
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя по его паспорту
     * @param passport паспорт клиета-его уникальный ключ
     * @return  возвращает нужного пользователя при условии, что пользователь с
     * искомым номером паспорта найден. null, если клиент не найден
     */
    public User findByPassport(String passport) {
        User search = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                search = user;
                break;
            }
        }
        return search;
    }

    /**
     * Метод для поиска пользователя по его номеру счёта
     * @param passport паспорт клиета-его уникальный ключ
     * @param requisite номер счёта. Также уникален, как и паспорт
     * @return  возвращает нужного пользователя при условии, что пользователь с
     * искомым номером паспорта и номером счёта найден. null, если клиент не найден
     */
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

    /**
     * Метод для перевода денег по номеру счёта
     * @param srcPassport паспорт отправителя
     * @param srcRequisite номер счёта отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite номер счёта получателя
     * @param amount сумма перевода
     * @return возвращает true в случае успешного перевода. false в случае неудачи
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account first = findByRequisite(srcPassport, srcRequisite);
        Account second = findByRequisite(destPassport, destRequisite);
        if (first != null && second != null && first.getBalance() >= amount) {
            first.setBalance(first.getBalance() - amount);
            second.setBalance(second.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список всех счетов нужного пользователя
     * @param user пользователь, счета которого запрашиваются
     * @return возвращает все счета ползователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}