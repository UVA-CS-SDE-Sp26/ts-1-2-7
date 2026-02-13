import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    @TempDir
    Path tempDir;

    private FileHandler fileHandler;
    private Path dataDir;

    @BeforeEach
    public void setUp() throws IOException {
        dataDir = tempDir.resolve("data");
        Files.createDirectory(dataDir);
        fileHandler = new FileHandler(dataDir.toString());
    }


    @Test
    public void testConstructorWithParameter() {
        FileHandler handler = new FileHandler("custom/path");
        assertNotNull(handler);
    }

    @Test
    public void testDefaultConstructor() {
        FileHandler handler = new FileHandler();
        assertNotNull(handler);
    }

    @Test
    public void testListFiles_WithMultipleTxtFiles() throws IOException {
        Files.createFile(dataDir.resolve("file1.txt"));
        Files.createFile(dataDir.resolve("file2.txt"));
        Files.createFile(dataDir.resolve("file3.txt"));
        List<String> files = fileHandler.listFiles();
        assertEquals(3, files.size());
        assertTrue(files.contains("file1.txt"));
    }

    @Test
    public void testListFiles_SortedAlphabetically() throws IOException {
        Files.createFile(dataDir.resolve("text1.txt"));
        Files.createFile(dataDir.resolve("text2.txt"));
        Files.createFile(dataDir.resolve("text3.txt"));
        List<String> files = fileHandler.listFiles();
        assertEquals("text1.txt", files.get(0));
        assertEquals("text2.txt", files.get(1));
        assertEquals("text3.txt", files.get(2));
    }

    @Test
    public void testListFiles_FiltersNonTxtFiles() throws IOException {
        Files.createFile(dataDir.resolve("document.txt"));
        Files.createFile(dataDir.resolve("image.jpg"));
        List<String> files = fileHandler.listFiles();
        assertEquals(1, files.size());
        assertEquals("document.txt", files.get(0));
    }

    @Test
    public void testListFiles_DirectoryNotFound() {
        FileHandler badHandler = new FileHandler("nonexistent");
        assertThrows(IOException.class, () -> badHandler.listFiles());
    }

    @Test
    public void testListFiles_NoTxtFiles() throws IOException {
        Files.createFile(dataDir.resolve("file.pdf"));
        assertThrows(IOException.class, () -> fileHandler.listFiles());
    }

    @Test
    public void testListFiles_EmptyDirectory() {
        assertThrows(IOException.class, () -> fileHandler.listFiles());
    }


    @Test
    public void testReader_ValidFile() throws IOException {
        String content = "Here";
        Files.writeString(dataDir.resolve("test.txt"), content);
        assertEquals(content, fileHandler.reader("test.txt"));
    }

    @Test
    public void testReader_EmptyFile() throws IOException {
        Files.createFile(dataDir.resolve("empty.txt"));
        assertEquals("", fileHandler.reader("empty.txt"));
    }

    @Test
    public void testReader_FileNotFound() {
        assertThrows(IOException.class, () -> fileHandler.reader("nonexistent.txt"));
    }

}