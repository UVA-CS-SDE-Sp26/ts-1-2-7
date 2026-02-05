/**
 * Commmand Line Utility
 */
public class TopSecret {
    // userInput may have 1 or 2 arguments
        // The first = file number
        // The second = cipher
    String[] userInput;

    // Called from main with appropriate data
    public TopSecret(String[] userInput) {
        this.userInput = userInput;
    }

    // Team Member C - Emma
        // Connect command line to file handler
        // Request file contents
        // Return readable text
    public void connector(String[] userInput) {
        // If no arguments
        if (userInput.length == 0) {
            // List the numbered files available to display
            printFileList();
        }

        // If more than one argument
        if (userInput.length >= 1) {
            // Contents of corresponding file is displayed
            // Call B's function

            // No second argument, then use the default key for deciphering
            // If a second argument, then use alternate key for deciphering
        }
        // If program executed with an error argument → display an error message
        // The program exits after showing the file list, the contents of an indicated file, or after displaying an error message
    }

    public void printFileList() {

    }
}
