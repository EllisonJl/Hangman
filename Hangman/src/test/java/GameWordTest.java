import org.junit.jupiter.api.Test;
import stacs.GameWord;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

class GameWordTest {

    @Test
    void testGetRandomWordReturnsNonNull() {
        String word = GameWord.getRandomWord();
        assertNotNull(word, "getRandomWord() should return a non-null word.");
    }

    @Test
    void testGetRandomWordReturnsValidWord() {
        Set<String> words = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String word = GameWord.getRandomWord();
            assertNotNull(word, "getRandomWord() should return a non-null word.");
            words.add(word);
        }

        assertTrue(words.size() > 1, "getRandomWord() should return different words when called multiple times.");
    }
}
