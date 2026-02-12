import org.junit.jupiter.api.Test;

import java.io.File;
// Need help with this and designing test
import static org.junit.jupiter.api.Assertions.*;

class cipherTest {

    @Test
    void testToString() {
        File key = new File("./ciphers/key.txt/");
        File test = new File("./ciphers/KWtester.txt/");
        cipher Cipher = new cipher(test, key);
        String actualdecipheredText = Cipher.toString();
        assertEquals("Kate Walldorf", actualdecipheredText);
    }
}