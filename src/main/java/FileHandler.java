import java.io.*;
import java.nio.file.*;
import java.util.*;


public class FileHandler {
    private static final String dataDirectory = "data";
    public List<String> listFiles() throws IOException {
        File data = new File(dataDirectory);
        if (!data.exists() || !data.isDirectory()) {
            throw new IOException ("Data directory not found:" + dataDirectory);
        }
        String[] files = data.list();

        if (files == null || files.length ==0){
            throw new IOException ("No .txt files found in:" + dataDirectory);
        }
        List<String> txtFiles = new ArrayList<>();
        for (String filename : files) {
            if (filename.endsWith(".txt")) {
                txtFiles.add(filename);
            }
        }
        if (txtFiles.isEmpty()) {
            throw new IOException("No .txt files found in " + dataDirectory);
        }
        Collections.sort(txtFiles);
        return txtFiles;

    }
    public String reader(String filename) throws IOException {
        Path files =  Paths.get(dataDirectory, filename);
        if (!Files.exists(files)) {
            throw new IOException ("File not found: " + filename);
        }
        if (!Files.isRegularFile(files)) {
            throw new IOException ("Not a regular: " + filename);
        }
        return Files.readString(files);

    }
    }
