package com.example.caesar;

public class Caesar {
    public static void main(String[] args) {
        char operation;
        String str, result = "";
        int offset;
        boolean goodArgs = checkArgs(args);
        if (goodArgs == true) {
            if (args[0] == "-e" || args[0] == "-d") {
                operation = args[0].charAt(1);
                str = args[1];
                offset = Integer.parseInt(args[3]);
                if (operation == 'e') {
                    result = encrypt(str, offset);
                } else {
                    result = decrypt(str, offset);
                }
            } else if (args[2] == "-e" || args[2] == "-d") {
                operation = args[2].charAt(1);
                str = args[3];
                offset = Integer.parseInt(args[1]);
                if (operation == 'e') {
                    result = encrypt(offset, str);
                } else {
                    result = decrypt(offset, str);
                }
            }
            System.out.println(result);
        }
    }

    public static boolean checkArgs(String[] args) {
        if (args.length != 4) {
            System.out.println("Wrong number of arguments!");
            return false;
        }
        if (args[0].length() != 2 || args[2].length() != 2) {
            System.out.println("Wrong order of arguments!");
            return false;
        }
        if (((args[0] != "-e" && args[0] != "-d") || args[2] != "-o") &&
                ((args[2] != "-e" && args[2] != "-d") || args[1] != "-o")) {
            System.out.println("Wrong flags! Please enter correct flags!");
            return false;
        }
        if (args[2] == "-o") {
            if (Integer.parseInt(args[3]) < 1) {
                System.out.println("Not positive offset! Please enter number above 0!");
                return false;
            }
        } else if (args[0] == "-o") {
            if (Integer.parseInt(args[1]) < 1) {
                System.out.println("Not positive offset! Please enter number above 0!");
                return false;
            }
        }
        if (args[2] == "-o") {
            for (int i = 0; i < args[1].length(); i++) {
                if (args[1].charAt(i) > 126) {
                    System.out.println("Wrong encoding! Please use ASCII !");
                    return false;
                }
                ;
            }
        } else if (args[0] == "-o") {
            for (int i = 0; i < args[3].length(); i++) {
                if (args[3].charAt(i) > 126) {
                    System.out.println("Wrong encoding! Please use ASCII !");
                    return false;
                }
                ;
            }
        }
        return true;
    }

    public static String encrypt(String str, int offset) {
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char character = str.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character += offset;
                if (character > 'Z') {
                    character -= 26;
                }
            } else if (character >= 'a' && character <= 'z') {
                character += offset;
                if (character > 'z') {
                    character -= 26;
                }
            }
            newStr += character;
        }
        return newStr;
    }

    public static String encrypt(int offset, String str) {
        return encrypt(str, offset);
    }

    public static String decrypt(String str, int offset) {
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char character = str.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                character -= offset;
                if (character < 'A') {
                    character += 26;
                }
            } else if (character >= 'a' && character <= 'z') {
                character -= offset;
                if (character < 'a') {
                    character += 26;
                }
            }
            newStr += character;
        }
        return newStr;
    }

    public static String decrypt(int offset, String str) {
        return decrypt(str, offset);
    }
}
