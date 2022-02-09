package com.example.caesar;

public class Caesar {
    public static void main(String[] args) {
        char operation;
        String str, result;
        int offset;
        if (args.length == 4) {
            if (args[0].charAt(1) == 'e' || args[0].charAt(1) == 'd') {
                operation = args[0].charAt(1);
                str = args[1];
                offset = Integer.parseInt(args[3]);
                if (operation == 'e') {
                    result = Encrypt(str, offset);
                } else {
                    result = Decrypt(str, offset);
                }
                System.out.println(result);
            } else if (args[2].charAt(1) == 'e' || args[2].charAt(1) == 'd') {
                operation = args[2].charAt(1);
                str = args[3];
                offset = Integer.parseInt(args[1]);
                if (operation == 'e') {
                    result = Encrypt(str, offset);
                } else {
                    result = Decrypt(str, offset);
                }
                System.out.println(result);
            } else {
                System.out.println("Wrong arguments" +
                        "\nExample of input: -e/-d \"sentence to encrypt/decrypt\" -o offset_number" +
                        "\n-e - encrypt\n-d - decrypt\n-o - offset");
            }
        }
    }
     /*       for (int i = 0; i<str.length(); i++){
                if (str.charAt(i) > 127){
                    System.out.println("Wrong sentence encoding" +
                            "\nExample of input: -e/-d \"sentence to encrypt/decrypt\" -o offset_number" +
                            "\n-e - encrypt\n-d - decrypt\n-o - offset");
                    break;
                }
            }

            if ((operation == 'e' || operation == 'd') && str != "" && offset > 0) {
                String result = cipher(operation, str, offset);
                System.out.println(result);
            }
            else {
                System.out.println("Wrong arguments" +
                        "\nExample of input: -e/-d \"sentence to encrypt/decrypt\" -o offset_number" +
                        "\n-e - encrypt\n-d - decrypt\n-o - offset");
            }
        }
        else if (args.length < 4){
            System.out.println("Too few arguments" +
                    "\nExample of input: -e/-d \"sentence to encrypt/decrypt\" -o offset_number" +
                    "\n-e - encrypt\n-d - decrypt\n-o - offset");
        }
        else {
            System.out.println("Too many arguments" +
                    "\nExample of input: -e/-d \"sentence to encrypt/decrypt\" -o offset_number" +
                    "\n-e - encrypt\n-d - decrypt\n-o - offset");
        }
    }*/

    public static String Encrypt(String str, int offset){
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++){
            char character = str.charAt(i);
            if (character >= 'A' && character <='Z') {
                character += offset;
                if (character > 'Z'){
                    character -= 26;
                }
            }
            else if (character >= 'a' && character <='z') {
                character += offset;
                if (character > 'z'){
                    character -= 26;
                }
            }
            newStr += character;
        }
        return newStr;
    }

    public static String Encrypt(int offset, String str){
        return Encrypt(str, offset);
    }

    public static String Decrypt(String str, int offset){
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++){
            char character = str.charAt(i);
            if (character >= 'A' && character <='Z') {
                character -= offset;
                if (character < 'A'){
                    character += 26;
                }
            }
            else if (character >= 'a' && character <='z') {
                character -= offset;
                if (character < 'a'){
                    character += 26;
                }
            }
            newStr += character;
        }
        return newStr;
    }
    public static String Decrypt(int offset, String str){
        return Decrypt(str, offset);
    }
}
