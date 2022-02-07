import java.util.Scanner;

public class caesar {
    public static void main(String[] args) {
        char operation = args[0].charAt(1);
        String str = args[1];
        int offset = Integer.parseInt(args[3]);

        String result = cipher(operation, str, offset);
        System.out.println(result);

        Scanner in = new Scanner(System.in);
        System.out.println("Press Any Key To Continue...");
        in.nextLine();
    }

    public static String cipher(char operation, String str, int offset){
        String newStr = "";
        int n = str.length();
        for (int i = 0; i < n; i++){
            char character = str.charAt(i);
            int icharacter = (int) character;
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
