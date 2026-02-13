import java.io.*;
import java.util.*;

public class UserInterface {
    private ProgramControl programControl;

    public UserInterface() {
        this.programControl = new ProgramControl();
    }

    public UserInterface(ProgramControl programControl) {
        this.programControl = programControl;
    }

    public void runProgram(String[] args) {
        programControl.main(args);
    }
}
        /*
            List<String> fileNames = fileHandler.listFiles();

            if (args.length == 0){//if no arguments, just print list of files
                for (int i = 0; i < fileNames.size(); i++) {
                    System.out.println("0" + (i+1) + " " + fileNames.get(i));
                }
                return;
            }

            if (args.length >= 1){ //if one or more arguments, display the file
                int index = Integer.parseInt(args[0])-1; //converts string into a number

                if (index < 0 || index >= fileNames.size()){ //if given argument does not work
                    System.out.println("Invalid");
                    return;
                }

                String selectFile = fileNames.get(index); //gets selected file
                File cipherFile = new File("data", selectFile); //creates a file object
                File key;

                if (args.length == 1){//selects key to decipher with
                    key = new File("data", "key");
                } else {
                    key = new File("data", args[1]);
                }

                cipher decipher = new cipher(cipherFile,key); //deciphers the file
                System.out.println(decipher.toString()); //prints deciphered file
            }
    */