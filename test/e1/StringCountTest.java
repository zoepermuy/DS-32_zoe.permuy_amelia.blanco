package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCountTest {

    @Test
    void countWords() {
        assertEquals(0, StringCount.countWords(null));
        assertEquals(0, StringCount.countWords(""));
        assertEquals(0, StringCount.countWords("     "));
        assertEquals(1, StringCount.countWords("Hello"));
        assertEquals(2, StringCount.countWords("Hello World"));
        assertEquals(2, StringCount.countWords("Hello  World"));
        assertEquals(2, StringCount.countWords(" Hello  World"));
        assertEquals(2, StringCount.countWords("Hello  World "));
        assertEquals(3, StringCount.countWords("Hello  beautiful World "));
    }

    @Test
    void countChar() {
        assertEquals(0, StringCount.countChar(null, 'a'));
        assertEquals(0, StringCount.countChar("", 'a'));
        assertEquals(0, StringCount.countChar("Hello World", 'a'));
        assertEquals(0, StringCount.countChar("Hello World", 'E'));
        assertEquals(1, StringCount.countChar("Hello World", 'e'));
        assertEquals(2, StringCount.countChar("Hello World", 'o'));
        assertEquals(1, StringCount.countChar("Hello World", 'H'));
        assertEquals(0, StringCount.countChar("hello World", 'H'));
        assertEquals(1, StringCount.countChar("Perú", 'ú'));
        assertEquals(0, StringCount.countChar("Perú", 'u'));
        assertEquals(4, StringCount.countChar("AAAaaaa", 'a'));

    }

    @Test
    void countCharIgnoringCase() {
        assertEquals(0, StringCount.countCharIgnoringCase(null, 'a'));
        assertEquals(0, StringCount.countCharIgnoringCase("", 'a'));
        assertEquals(0, StringCount.countCharIgnoringCase("Hello World", 'a'));
        assertEquals(1, StringCount.countCharIgnoringCase("Hello World", 'e'));
        assertEquals(1, StringCount.countCharIgnoringCase("Hello World", 'E'));
        assertEquals(2, StringCount.countCharIgnoringCase("Hello World", 'o'));
        assertEquals(2, StringCount.countCharIgnoringCase("Hello World", 'O'));
        assertEquals(1, StringCount.countCharIgnoringCase("PerúUu", 'ú'));
        assertEquals(2, StringCount.countCharIgnoringCase("PerúUuÚ", 'U'));
    }

    @Test
    void isPasswordSafe() {
        assertFalse(StringCount.isPasswordSafe("contra")); //sin 8 caracteres
        assertFalse(StringCount.isPasswordSafe("contraseña?8")); //sin mayuscula
        assertFalse(StringCount.isPasswordSafe("CONTRASEÑA?8")); //sin minuscula
        assertFalse(StringCount.isPasswordSafe("Contraseña?")); //sin numero
        assertFalse(StringCount.isPasswordSafe("Contraseña8")); //sin caracter
        assertFalse(StringCount.isPasswordSafe("Contraseña¿8")); //sin caracter
        assertTrue(StringCount.isPasswordSafe("Contraseña?8"));
        assertTrue(StringCount.isPasswordSafe("Contraseña#8"));
        assertTrue(StringCount.isPasswordSafe("Contraseña@8"));
        assertTrue(StringCount.isPasswordSafe("Contraseña$8"));
        assertTrue(StringCount.isPasswordSafe("Contraseña.8"));
        assertTrue(StringCount.isPasswordSafe("Contraseña,8"));
    }
}