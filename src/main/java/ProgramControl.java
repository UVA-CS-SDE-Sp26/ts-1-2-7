import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProgramControl {
    private FileHandler fileHandler;
    private cipher cipher;

    // For testing purposes (eventually overwritten)
    File message = new File("hello");
    File key = new File("key.txt");

    // For testing purposes
    private String test;

    // Getters and setters
    public FileHandler getFileHandler() {
        return fileHandler;
    }
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public cipher getCipher() {
        return cipher;
    }
    public void setCipher(cipher cipher) {
        this.cipher = cipher;
    }

    public String getTest() {
        return test;
    }

    // Constructors
    public ProgramControl() {
        fileHandler = new FileHandler();
        cipher = new cipher(message, key);
    }

    // Constructor for testing purposes
    public ProgramControl(cipher cipher) {
        fileHandler = new FileHandler();
        this.cipher = cipher;
    }

    public void main(String[] args) {
        try {
            // Call B's listFiles() method, returns a list of files
            List<String> fileList = fileHandler.listFiles();

            // If no arguments
            if (args.length == 0) {
                // List the numbered files available to display
                for (int i = 0; i < fileList.size(); i++) {
                    if (i < 9) {
                        System.out.println("0" + (i+1) + " " + fileList.get(i));
                    } else {
                        System.out.println((i+1) + " " + fileList.get(i));
                    }
                }

                // For testing purposes
                test = "No argument test is done.";
                return;
            }

            int fileIndex = Integer.parseInt(args[0]) - 1; // Transform into an index
            // Check that fileIndex is valid
            if (fileIndex < 0 || fileIndex >= fileList.size()) {
                return;
            }

            // If there are arguments
            String fileName = fileList.get(fileIndex);

            // Create a path to the data
            File message = new File("data", fileName);

            // No second argument, then use the default key for deciphering
            if (args.length == 1) {
                // Create a path to default key
                File key = new File("ciphers", "key.txt");

                // Check that key is valid
                if (!key.exists()) {
                    throw new IllegalArgumentException("Invalid key file");
                }

                cipher = new cipher(message, key);
                cipher.printCipher(); // Print the ciphered text

                // For testing purposes
                test = "1 argument test is done.";
                return;
            }

            // If a second argument, then use alternate key for deciphering
            if (args.length == 2) {
                // Create a path to alternate key
                String alternateCipher = args[1];
                File key = new File("ciphers", alternateCipher);

                // Check that key is valid
                if (!key.exists()) {
                    throw new IllegalArgumentException("Invalid key file");
                }

                cipher = new cipher(message, key);
                cipher.printCipher(); // Print the ciphered text

                // For testing purposes
                test = "2 argument test is done.";
            }
        } catch (IOException e) {
            // File does not exist
            throw new IllegalArgumentException("Not a valid file. File does not exist");
        } catch (NumberFormatException e) {
            // User typed something that is not a number
            throw new NumberFormatException("Not a valid number.");
        }
    }
}