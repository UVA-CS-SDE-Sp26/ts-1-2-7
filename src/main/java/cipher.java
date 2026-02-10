import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cipher {
    private String decipheredText = "";
    private String cipheredText;
    private String currentLetter;
    private String keyInput;
    private String keyOutput;

    private int inputIndex;

    public cipher(File cipheredMessage, File key) {
        try (Scanner reader = new Scanner (cipheredMessage)) {
            try(Scanner keyReader = new Scanner(key)) {
                cipheredText = reader.next();
                keyInput = keyReader.next();
                keyOutput = keyReader.next();
                for (int i = 0; i < cipheredText.length(); i++) {
                    currentLetter += cipheredText.charAt(i);
                    inputIndex = keyInput.indexOf(currentLetter);
                    decipheredText += keyOutput.charAt(inputIndex);
                    currentLetter = "";
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("Key not found");
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Ciphered text file not found");
        }
    }

    public String toString() {
        return decipheredText;
    }
}
