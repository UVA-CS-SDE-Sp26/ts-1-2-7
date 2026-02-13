import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cipher {
    private String decipheredText = "";
    private String cipheredText;
    private String keyInput;
    private String keyOutput;

    public cipher(File cipheredMessage, File key) {
        try (Scanner reader = new Scanner (cipheredMessage)) {
            cipheredText = reader.nextLine();
            System.out.println(cipheredText);
        }
        catch (FileNotFoundException e) {
            System.out.println("Ciphered text file not found");
        }
        try(Scanner keyReader = new Scanner(key)) {
            keyInput = keyReader.next();
            keyOutput = keyReader.next();
        }
        catch (FileNotFoundException e) {
            System.out.println("Key not found");
        }
        if(cipheredText.length() > 0) {
            for (int i = 0; i < cipheredText.length(); i++) {
                char letter = cipheredText.charAt(i);
                int inputIndex = keyInput.indexOf(letter);
                if (inputIndex != -1) {
                    decipheredText += keyOutput.charAt(inputIndex);
                } else {
                    decipheredText += letter;
                }
            }
        }
        else {
            System.out.println("Ciphered text is empty");
        }
    }

    public void printCipher() {
        System.out.println(decipheredText);
    }
}
