import java.io.File;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.runProgram(args);
        // ProgramControl program = new ProgramControl(args);
        // program.connector(args);
        File key = new File("./ciphers/key.txt");
        File test = new File("./ciphers/Tester.txt");
        cipher Cipher = new cipher(test, key);
        String decipheredText = Cipher.toString();
    }
}