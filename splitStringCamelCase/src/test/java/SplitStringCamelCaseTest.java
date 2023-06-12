import org.example.SplitStringCamelCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplitStringCamelCaseTest {

    @Test
    public void splitSimpleString() {
        SplitStringCamelCase splitStringCamelCas = new SplitStringCamelCase();
        String string = "nome";

        String stringConverted = splitStringCamelCas.converterCamelCase(string);

        assertEquals(string, stringConverted);
    }

    @Test
    public void splitSimpleStringWithCamelCase() {
        SplitStringCamelCase splitStringCamelCas = new SplitStringCamelCase();
        String string = "Nome";

        String stringConverted = splitStringCamelCas.converterCamelCase(string);

        assertEquals(string.toLowerCase(), stringConverted);
    }
}
