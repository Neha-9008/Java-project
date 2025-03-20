import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeTranslator {
    private static final HashMap<Character, String> morseMap = new HashMap<>();
    private static final HashMap<String, Character> reverseMorseMap = new HashMap<>();

    static {
        // Define Morse Code mappings
        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split("");
        String[] morseCodes = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
        };

        // Fill HashMaps for encoding and decoding
        for (int i = 0; i < letters.length; i++) {
            morseMap.put(letters[i].charAt(0), morseCodes[i]);
            reverseMorseMap.put(morseCodes[i], letters[i].charAt(0));
        }

        // Add space mapping
        morseMap.put(' ', "/");
        reverseMorseMap.put("/", ' ');
    }

    // Convert text to Morse code
    public static String textToMorse(String text) {
        text = text.toUpperCase();
        StringBuilder morse = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (morseMap.containsKey(ch)) {
                morse.append(morseMap.get(ch)).append(" ");
            } else {
                morse.append("? "); // Unknown character
            }
        }
        return morse.toString().trim();
    }

    // Convert Morse code to text
    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morse.split(" ");

        for (String morseChar : morseWords) {
            text.append(reverseMorseMap.getOrDefault(morseChar, '?'));
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Morse Code Translator");
        System.out.println("1. Convert Text to Morse Code");
        System.out.println("2. Convert Morse Code to Text");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter text to convert: ");
            String text = scanner.nextLine();
            System.out.println("Morse Code: " + textToMorse(text));
        } else if (choice == 2) {
            System.out.print("Enter Morse Code (use space between characters, '/' for space): ");
            String morse = scanner.nextLine();
            System.out.println("Text: " + morseToText(morse));
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
