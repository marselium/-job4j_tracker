package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static boolean isSubstring(String word) {
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        String low = word.toLowerCase();
        boolean rsl = false;
        for (String substring : substrings) {
            if (low.contains(substring)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static String validate(String password) {
        boolean isDigit = false;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean isSpec = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (char symbol : password.toCharArray()) {
            if (isDigit(symbol)) {
                isDigit = true;
            }
            if (isUpperCase(symbol)) {
                upperCase = true;
            }
            if (isLowerCase(symbol)) {
                lowerCase = true;
            }
            if (!isDigit(symbol) && !isLetter(symbol)) {
                isSpec = true;
            }
            if (isDigit && upperCase && lowerCase && isSpec) {
                break;
            }
        }

        if (!upperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit) {
            throw new IllegalArgumentException(("Password should contain at least one figure"));
        }
        if (!isSpec) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (isSubstring(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
