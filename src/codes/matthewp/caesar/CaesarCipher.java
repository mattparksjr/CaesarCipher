package codes.matthewp.caesar;

import java.util.Scanner;

public class CaesarCipher {

    private static final String possChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1!2@3#4$5%6^7&8*9(0)";
    private static boolean acceptInput = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (acceptInput) {
            System.out.println("Would you like to encrypt(E), decrypt(D), or quit(Q)?");
            System.out.print("Please enter your selection: ");
            String input = scanner.next();
            scanner.nextLine(); // This must be added for some odd reason, it skips the \n character at EOL
            if (input.equalsIgnoreCase("E")) {
                System.out.println("Please enter the number of shifts: ");
                int shifts = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the message you would like to encode:");
                String str = encode(scanner.nextLine(), shifts);
                System.out.println("Encoding message...");
                System.out.println("Message encoded as: " + str);
            } else if (input.equalsIgnoreCase("D")) {
                System.out.println("Please enter the number of shifts: ");
                int shifts = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the message you would like to decode: ");
                String str = decode(scanner.nextLine(), shifts);
                System.out.println("Encoding message...");
                System.out.println("Message decoded as: " + str);
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("Quitting....");
                scanner.close();
                acceptInput = false;
            }
        }
    }

    private static String encode(String s, int shifts) {
        StringBuilder output = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character == ' ') {
                output.append(" ");
                continue;
            }
            int index = possChars.indexOf(character);
            index += shifts;
            if (index >= possChars.length()) {
                index = (index - possChars.length());
            }
            output.append(possChars.toCharArray()[index]);
        }
        return output.toString();
    }

    private static String decode(String s, int shifts) {
        StringBuilder output = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character == ' ') {
                output.append(" ");
                continue;
            }
            int index = possChars.indexOf(character);
            index -= shifts;
            if (index <= 0) {
                index = (index + possChars.length());
            }
            output.append(possChars.toCharArray()[index]);
        }
        return output.toString();
    }
}
