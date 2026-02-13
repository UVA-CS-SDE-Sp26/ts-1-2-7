import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cipher {
    private String decipheredText = "";
    private String cipheredText;
    private String keyInput;
    private String keyOutput;

    public cipher(File cipheredMessage, File key) {
        try (Scanner reader = makeScanner (cipheredMessage)) {
            StringBuilder message = new StringBuilder();
            while(reader.hasNextLine()){
                message.append(reader.nextLine());
                message.append("\n");
            }
            cipheredText = message.toString();
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Ciphered text file not found");
        }
        try(Scanner keyReader = makeScanner(key)) {
            keyInput = keyReader.next();
            keyOutput = keyReader.next();
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Key not found");
        }
        if(cipheredText != null && cipheredText.length() > 0) {
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

    // For testing purposes (ProgramControlTest.java)
    public void printCipher() {
        System.out.println(decipheredText);
    }
    protected Scanner makeScanner(File file) throws FileNotFoundException{
        return new Scanner(file);
    }
   public String toString() {
        return decipheredText;
    }
}
