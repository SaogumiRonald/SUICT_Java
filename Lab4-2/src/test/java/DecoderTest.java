import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoderTest {
    private Decoder decoder;

    @BeforeEach
    void setUp() {
        decoder = new Decoder();
    }

    @Test
    void testDecodeVowel() {
        assertEquals("test", decoder.decodeVowel("t2st"));
    }

    @Test
    void testDecodeConsonant() {
        assertEquals("test", decoder.decodeConsonant("sers"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", decoder.decode(""));
    }

    @Test
    void testDecodeWithoutMatchingCharacters() {
        assertEquals("123456789", decoder.decode("123456789"));
    }
}
