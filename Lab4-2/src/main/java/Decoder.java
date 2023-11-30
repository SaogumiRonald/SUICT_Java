import java.util.*;

public class Decoder {

    public static StringBuilder decodeVowel(String string){
        final Map<Character, Character> mapVowel = new HashMap<>() {
            {
                put('1', 'a');
                put('2', 'e');
                put('3', 'i');
                put('4', 'o');
                put('5', 'u');
            }
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (mapVowel.get(string.toCharArray()[i]) == null) {
                result.append(string.toCharArray()[i]);
            } else {
                result.append(mapVowel.get(string.toCharArray()[i]));
            }
        }
        return result;
    }

    public static String decodeConsonant(String string){
        StringBuilder decoded = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                char decodedChar = getNextConsonant(c);
                decoded.append(decodedChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }


    private static char getNextConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int index = consonants.indexOf(Character.toLowerCase(c));
        if (index != -1) {
            char nextConsonant = consonants.charAt((index + 1) % consonants.length());
            return Character.isUpperCase(c) ? Character.toUpperCase(nextConsonant) : nextConsonant;
        }
        return c;
    }

    public String decode(String string) {
        if (string.isEmpty()) {
            return string;
        }

        if (string.matches("[a-zA-z1-5]")) {
            decodeVowel(string);
        } else if (string.matches("[a-zA-Z]")){
            decodeConsonant(string);
        }

        return string;
    }
}