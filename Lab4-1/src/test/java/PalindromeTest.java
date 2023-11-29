import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromeTest {
    Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void isPalindrome() {
        assertFalse(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("radar"));
        assertTrue(palindrome.isPalindrome("Madam"));
        assertTrue(palindrome.isPalindrome("madam"));
        assertTrue(palindrome.isPalindrome("10101"));
        assertTrue(palindrome.isPalindrome("Was it a car or a cat I saw?"));
        assertTrue(palindrome.isPalindrome("Not New York\", – Roy went on"));
        assertFalse(palindrome.isPalindrome("It is not palindrome"));
        assertFalse(palindrome.isPalindrome("sjnsa"));
        assertFalse(palindrome.isPalindrome("tree"));
        assertFalse(palindrome.isPalindrome("123456789"));
    }
}