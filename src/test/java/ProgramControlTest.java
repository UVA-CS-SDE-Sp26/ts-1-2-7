import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProgramControlTest {
    // No argument test
    @Test
    void noArgTest() throws IOException {
        String[] args = new String[0];

        cipher cipher = mock(cipher.class); // Mock cipher class
        ProgramControl programControl = new ProgramControl(cipher);

        FileHandler fileHandler = mock(FileHandler.class); // Mock FileHandler class
        programControl.setFileHandler(fileHandler);

        // Create a fake list of files that listFiles() will return
        ArrayList<String> fileList = new ArrayList<>();
        fileList.add("test1.txt");
        fileList.add("test2.txt");

        // Tell the mock FileHandler to return our fake file list whenever listFiles() is called
        when(fileHandler.listFiles()).thenReturn(fileList);

        // Run main with no arguments, should list files and set test string
        programControl.main(args);

        // Verify that ProgramControl set the test string correctly for the no argument case
        assertEquals("No argument test is done.", programControl.getTest());
    }

    // 1 argument test
    @Test
    void oneArgTest() throws IOException {
        String[] args = {"1"};

        cipher cipher = mock(cipher.class); // Mock cipher class
        ProgramControl programControl = new ProgramControl(cipher);

        programControl.setCipher(cipher);

        // Run main with 1 valid argument, should use default key and call cipher.printCipher()
        programControl.main(args);

        // Verify that ProgramControl set the test string correctly for the 1 argument case
        assertEquals("1 argument test is done.", programControl.getTest());
    }

    // 2 argument test
    @Test
    void twoArgTest() throws IOException {
        String[] args = {"1", "key.txt"};

        cipher cipher = mock(cipher.class); // Mock cipher class
        ProgramControl programControl = new ProgramControl(cipher);

        programControl.setCipher(cipher);

        // Run main with 2 valid arguments, should use alternate key and call cipher.printCipher()
        // Used "key.txt" instead of a fake alternate key like "altkey.txt" - ran into issues because "altkey.txt" does not exist
        // Still verifies the 2 argument test even if the "alternate" key is the same as the default key
        programControl.main(args);

        // Verify that ProgramControl set the test string correctly for the 2 argument case
        assertEquals("2 argument test is done.", programControl.getTest());
    }

    // Testing if the first argument is invalid
    @Test
    void invalidNumTest() throws IOException {
        String[] args = {"hello", "key.txt"};

        cipher cipher = mock(cipher.class); // Mock cipher class
        ProgramControl programControl = new ProgramControl(cipher);

        // Run main() and verify that an NumberFormatException is thrown because invalid number
        assertThrows(NumberFormatException.class, () -> programControl.main(args));
    }

    // Testing if the second argument is invalid
    @Test
    void invalidFileTest() throws IOException {
        String[] args = {"1", "invalid.txt"};

        cipher cipher = mock(cipher.class); // Mock cipher class
        ProgramControl programControl = new ProgramControl(cipher);

        // Run main() and verify that an IllegalArgumentException is thrown because invalid file
        assertThrows(IllegalArgumentException.class, () -> programControl.main(args));
    }
}
