import org.example.Tradutor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TranslateTest {

    @Test
    public void translateWithoutWords() {
        Tradutor tradutor = new Tradutor();
        assertTrue(tradutor.isEmpty());
    }

    @Test
    public void oneTranslate() {
        Tradutor tradutor = new Tradutor();
        tradutor.addWord("bom", "good");
        assertTrue(tradutor.isEmpty());
    }
}