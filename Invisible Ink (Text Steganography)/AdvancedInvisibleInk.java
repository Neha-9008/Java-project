import java.io.*;
import java.util.Scanner;

public class AdvancedInvisibleInk {
    private static final char ZERO_WIDTH_SPACE = '\u200B';  // Represents binary '0'
    private static final char ZERO_WIDTH_NON_JOINER = '\u200C';  // Represents binary '1'

    // Encrypt the message (Caesar Cipher)
    private static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : message.toCharArray()) {
            encrypted.append((char) (ch + shift));
        }
        return encrypted.toString();
    }

    // Decrypt the message
    private static String decrypt(String message, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char ch : message.toCharArray()) {
            decrypted.append((char) (ch - shift));
        }
        return decrypted.toString();
    }

    // Encode the message into invisible characters
    public static String encode(String coverText, String secretMessage) {
        String encryptedMessage = encrypt(secretMessage, 3); // Encrypt with a shift of 3
        StringBuilder encodedMessage = new StringBuilder(coverText);

        for (char ch : encryptedMessage.toCharArray()) {
            String binary = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
            for (char bit : binary.toCharArray()) {
                encodedMessage.append(bit == '0' ? ZERO_WIDTH_SPACE : ZERO_WIDTH_NON_JOINER);
            }
        }

        return encodedMessage.toString();
    }

    // Decode the secret message from the invisible characters
    public static String decode(String stegoText) {
        StringBuilder binaryBuilder = new StringBuilder();
        StringBuilder secretMessage = new StringBuilder();

        for (char ch : stegoText.toCharArray()) {
            if (ch == ZERO_WIDTH_SPACE) {
                binaryBuilder.append('0');
            } else if (ch == ZERO_WIDTH_NON_JOINER) {
                binaryBuilder.append('1');
            }

            if (binaryBuilder.length() == 8) { // Convert every 8 bits to a character
                secretMessage.append((char) Integer.parseInt(binaryBuilder.toString(), 2));
                binaryBuilder.setLength(0);
            }
        }

        return decrypt(secretMessage.toString(), 3); // Decrypt with the same shift
    }

    // Save text to a file
    public static void saveToFile(String filename, String content) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(content);
            System.out.println("\nEncoded text saved to: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    // Read text from a file
    public static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
        return content.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select mode: Encode or Decode
        System.out.println("Select mode: \n1. Encode a message\n2. Decode a message");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter the cover text: ");
            String coverText = scanner.nextLine();

            System.out.print("Enter the secret message: ");
            String secretMessage = scanner.nextLine();

            // Encode message
            String stegoText = encode(coverText, secretMessage);
            System.out.println("\nEncoded (Steganographic) Text:\n" + stegoText);

            // Save to file option
            System.out.print("\nDo you want to save the encoded text to a file? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter file name (e.g., encoded.txt): ");
                String filename = scanner.nextLine();
                saveToFile(filename, stegoText);
            }

        } else if (choice == 2) {
            System.out.print("Do you want to decode from a file? (yes/no): ");
            String response = scanner.nextLine();

            String stegoText;
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter the file name: ");
                String filename = scanner.nextLine();
                stegoText = readFromFile(filename);
            } else {
                System.out.print("Enter the encoded text: ");
                stegoText = scanner.nextLine();
            }

            // Decode message
            String extractedMessage = decode(stegoText);
            System.out.println("\nExtracted Secret Message: " + extractedMessage);
        } else {
            System.out.println("Invalid option! Exiting...");
        }

        scanner.close();
    }
}
