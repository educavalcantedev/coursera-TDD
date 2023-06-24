import org.example.NumberInBeginException;
import org.example.SpecialCharacterException;
import org.example.SplitStringCamelCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SplitStringCamelCaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"nome", "Nome"})
    void splitSimpleString(String string) {
        List<String> stringConverted = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(stringConverted.size(), 1);
        assertEquals(stringConverted.get(0), string.toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(strings = {"nomeComposto", "NomeComposto"})
    void splitCompostString(String string) {
        List<String> stringConverted = SplitStringCamelCase.convertCamelCase(string);

        List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(listStringSplited.size(), 2);
        assertEquals(listStringSplited.get(0), "nome");
        assertEquals(listStringSplited.get(1), "composto");
    }
    @Test
    public void splitSimpleStringWithAllWordsUpperCase() {
        String string = "CPF";

        List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(listStringSplited.size(), 1);
        assertEquals(listStringSplited.get(0), "CPF");
    }

    @Test
    public void splitCompostStringWithLastWordUpperCase() {
        String string = "numeroCPF";

        List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(listStringSplited.size(), 2);
        assertEquals(listStringSplited.get(0), "numero");
        assertEquals(listStringSplited.get(1), "CPF");
    }

    @Test
    public void splitCompostStringWithMiddleWordUpperCase() {
        String string = "numeroCPFContribuinte";

        List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(listStringSplited.size(), 3);
        assertEquals(listStringSplited.get(0), "numero");
        assertEquals(listStringSplited.get(1), "CPF");
        assertEquals(listStringSplited.get(2), "contribuinte");
    }

    @Test
    public void splitCompostStringWithMiddleWordIsNumberUpperCase() {
        String string = "recupera10Primeiros";

        List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);

        assertEquals(listStringSplited.size(), 3);
        assertEquals(listStringSplited.get(0), "recupera");
        assertEquals(listStringSplited.get(1), "10");
        assertEquals(listStringSplited.get(2), "primeiros");
    }
    @Test
    public void throwsExceptionWhenStringStartedWithNumber() {
        String string = "10Primeiros";

        assertThrows(NumberInBeginException.class, () -> {
            List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);
        });
    }

    @Test
    public void throwsExceptionWhenStringHaveSpecialCharacter() {
        String string = "nome#Composto";

        assertThrows(SpecialCharacterException.class, () -> {
            List<String> listStringSplited = SplitStringCamelCase.convertCamelCase(string);
        });
    }
}
