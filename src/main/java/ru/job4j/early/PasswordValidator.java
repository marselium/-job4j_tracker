package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    public static boolean upperCase(String word) {
        boolean rsl = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean lowerCase(String word) {
        boolean rsl = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean isDigit(String word) {
        boolean rsl = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean isSpec(String word) {
        boolean rsl = false;
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);
            if ((ascii >= 32 && ascii <= 47) || (ascii >= 58 && ascii <= 64)
                    || (ascii >= 91 && ascii <= 96) || (ascii >= 123 && ascii <= 126)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

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
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!upperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit(password)) {
            throw new IllegalArgumentException(("Password should contain at least one figure"));
        }
        if (!isSpec(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (isSubstring(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}