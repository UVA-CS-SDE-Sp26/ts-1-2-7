import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class cipherTest {

    @Test
    void printCipher1() {
        File key1 = new File("./ciphers/key.txt");
        File test1 = new File("./ciphers/Tester.txt");
        cipher Cipher1 = new cipher(test1, key1);
        assertDoesNotThrow(() -> Cipher1.printCipher());
    }


    @Test
    void makeScanner() throws Exception {
        File test3 = new File("./ciphers/Tester.txt");
        cipher Cipher3 = new cipher(test3, new File("./ciphers/key.txt"));

        Scanner scanner = Cipher3.makeScanner(test3);

        assertNotNull(scanner);
        assertTrue(scanner.hasNextLine());

        scanner.close();
    }



    @Test
    void testToString() {
        File key = new File("./ciphers/key.txt");
        File test = new File("./ciphers/Tester.txt");
        cipher Cipher = new cipher(test, key);
        String actualdecipheredText = Cipher.toString();
        assertEquals("Two households, both alike in dignity,\n" +
                "In fair Verona, where we lay our scene,\n" +
                "From ancient grudge break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross’d lovers take their life;\n" +
                "Whose misadventured piteous overthrows\n" +
                "Do with their death bury their parents’ strife.\n" +
                "The fearful passage of their death-mark’d love,\n" +
                "And the continuance of their parents’ rage,\n" +
                "Which, but their children’s end, nought could remove,\n" +
                "Is now the two hours’ traffic of our stage;\n" +
                "The which if you with patient ears attend,\n" +
                "What here shall miss, our toil shall strive to mend.", actualdecipheredText);

    }
}
/*
class CipherTest {

    @Test
    void testToString() throws Exception {
        File cipheredText = new File("./ciphers/Tester.txt");
        File key = new File("./ciphers/key.txt");

        Scanner cipherScanner = mock(Scanner.class); //mock Cipher Scanner
        Scanner keyScanner = mock(Scanner.class); //mock Key Scanner

        String[] cipheredTextString = {
                "Svn gntrdgnkcr, ansg 0khjd hm chfmhsx,",
                "Hm e0hq Udqnm0, vgdqd vd k0x ntq rbdmd,",
                "Eqnl 0mbhdms fqtcfd aqd0j sn mdv ltshmx,",
                "Vgdqd bhuhk aknnc l0jdr bhuhk g0mcr tmbkd0m.",
                "Eqnl enqsg sgd e0s0k knhmr ne sgdrd svn endr",
                "z o0hq ne rs0q-bqnrr’c knudqr s0jd sgdhq khed;",
                "Vgnrd lhr0cudmstqdc ohsdntr nudqsgqnvr",
                "Cn vhsg sgdhq cd0sg atqx sgdhq o0qdmsr’ rsqhed.",
                "Sgd ed0qetk o0rr0fd ne sgdhq cd0sg-l0qj’c knud,",
                "zmc sgd bnmshmt0mbd ne sgdhq o0qdmsr’ q0fd,",
                "Vghbg, ats sgdhq bghkcqdm’r dmc, mntfgs bntkc qdlnud,",
                "Hr mnv sgd svn gntqr’ sq0eehb ne ntq rs0fd;",
                "Sgd vghbg he xnt vhsg o0shdms d0qr 0ssdmc,",
                "Vg0s gdqd rg0kk lhrr, ntq snhk rg0kk rsqhud sn ldmc."
        };

        String[] expectedText = {
                "Two households, both alike in dignity,\n " +
                        "In fair Verona, where we lay our scene,\n " +
                        "From ancient grudge break to new mutiny,\n " +
                        "Where civil blood makes civil hands unclean.\n " +
                        "From forth the fatal loins of these two foes\n " +
                        "A pair of star-cross’d lovers take their life;\n " +
                        "Whose misadventured piteous overthrows\n " +
                        "Do with their death bury their parents’ strife.\n " +
                        "The fearful passage of their death-mark’d love,\n " +
                        "And the continuance of their parents’ rage,\n " +
                        "Which, but their children’s end, nought could remove,\n " +
                        "Is now the two hours’ traffic of our stage;\n " +
                        "The which if you with patient ears attend,\n " +
                        "What here shall miss, our toil shall strive to mend.""
        };
        cipher Cipher = new cipher(cipheredText, key);
        String decipheredText = cipher.toString();
        assertEquals(expectedText, decipheredText);
    }
 */
