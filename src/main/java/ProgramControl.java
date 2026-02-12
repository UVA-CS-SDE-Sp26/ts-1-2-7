import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProgramControl {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();

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
                cipher cipheredText = new cipher(message, key);
                System.out.println(cipheredText);

                return;
            }

            // If a second argument, then use alternate key for deciphering
            if (args.length == 2) {
                // Create a path to alternate key
                String alternateCipher = args[1];
                File key = new File("ciphers", alternateCipher);
                cipher cipheredText = new cipher(message, key);
                System.out.println(cipheredText);
            }
        } catch (IOException e) {
            // File does not exist
            System.out.println("Not a valid file. File does not exist");
        } catch (NumberFormatException e) {
            // User typed something that is not a number
            System.out.println("Not a valid number.");
        }
    }
}