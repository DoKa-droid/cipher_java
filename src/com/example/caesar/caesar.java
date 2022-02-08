package com.example.caesar;

import java.util.Scanner;

public class caesar { //
    public static void main(String[] args) {
        char operation = 'a';
        String str = "";
        int offset = -1;
        if (args.length == 4) {
            if (args[0].charAt(1) == 'e' || args[0].charAt(1) == 'd') {
                operation = args[0].charAt(1);
                str = args[1];
                offset = Integer.parseInt(args[3]);
            }
            else if (args[2].charAt(1) == 'e' || args[2].charAt(1) == 'd') {
                operation = args[2].charAt(1);
                str = args[3];
                offset = Integer.parseInt(args[1]);
            }

            //if (operation != 'a' && str != "" && offset != )
            String result = cipher(operation, str, offset);
            System.out.println(result);

            Scanner in = new Scanner(System.in);
            System.out.println("Press Any Key To Continue...");
            in.nextLine();
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
    }

    public static String cipher(char operation, String str, int offset){
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++){
            char character = str.charAt(i);
            int icharacter = character;
            if (icharacter != 32) {
                if (operation == 'e') {
                    icharacter += offset;
                    if ((icharacter - offset <= 90 && icharacter > 90) || (icharacter - offset <= 122 && icharacter > 122)){
                        icharacter -= 26;
                    }
                } else if (operation == 'd') {
                    icharacter -= offset;
                    if ((icharacter + offset >= 65 && icharacter < 65) || (icharacter + offset >= 97 && icharacter < 97)){
                        icharacter += 26;
                    }
                }
            }
            character = (char) icharacter;
            newStr += character;
        }
        return newStr;
    }
}
