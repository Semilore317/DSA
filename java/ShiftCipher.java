package pre_extreme_problems;

import java.util.Scanner;

public class ShiftCipher {
    public static String shiftCipher(String input, int shift) {
        String lowerInput = input.toLowerCase();
        String[] words = lowerInput.split("\\s+");
        boolean isPlaintext = false;

        // check if contains exact word "the"
        for (String word : words) {
            if (word.equals("the")) {
                isPlaintext = true;
                break;
            }
        }

        // if plaintext, ENCRYPT (shift backward); else DECRYPT (shift forward)
        if (isPlaintext) {
            // ENCRYPT: shift backward
            shift = -shift;
        }

        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                result.append(' ');
            } else if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int shifted = (c - base + shift + 26) % 26 + base;
                result.append((char) shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        try {
            int N = Integer.parseInt(in.nextLine().trim());

            if (N < 1 || N > 25) {
                System.err.println("Invalid number of messages");
                return;
            }

            for (int i = 0; i < N; i++) {
                int shift = Integer.parseInt(in.nextLine().trim());
                if (shift < 1 || shift > 25) {
                    System.err.println("Invalid shift value");
                    continue;
                }
                String message = in.nextLine();

                String output = shiftCipher(message, shift);
                System.out.println(output);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input format");
        } finally {
            in.close();
        }
    }
}
