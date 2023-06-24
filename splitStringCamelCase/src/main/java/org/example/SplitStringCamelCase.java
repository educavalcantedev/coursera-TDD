package org.example;

import java.util.Arrays;
import java.util.List;

public class SplitStringCamelCase {
    public static List<String> convertCamelCase(String text){
        
        if(text.matches("^[0-9].*")) {
            throw new NumberInBeginException("Invalid word: cannot start with number!");
        }
           
        if(!text.matches("(\\w)*")) {
            throw new SpecialCharacterException("Invalid word: cannot start with special character!");
        }
            
        List<String> words;
        words = brokeText(text);
        return words;
    }
    
    private static List<String> brokeText(String text) {
        String[] words = text.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
        for(int i = 0; i < words.length; i++){
            words[i] = lowerCaseWord(words[i]);
        }
        return Arrays.asList(words);
    }

    private static String lowerCaseWord(String word) {
        if(word.matches("^[A-Z][a-z].*")) {
            word = word.substring(0,1).toLowerCase() + word.substring(1);
        }
        return word;
    }
}
