package wordle;

import java.util.Dictionary;
import java.util.Hashtable;

public class Utils {
    public static final String HIT = "*";
    public static final String MISS = "#";
    public static final String NOT_IN_WORD = "-";

    public static String check_word(String hidden_word, String word) throws Exception {
        if (!validate_same_length(hidden_word, word)) {
            throw new Exception("שגיאה האורך של המילה איננו מתאים לדרישות... ");
        }
        Dictionary hash = count_letters(hidden_word);
        String hits = get_hits(hash, hidden_word, word);
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            String current_position_in_hits_string = Character.toString(hits.charAt(i));
            if (current_position_in_hits_string.equals(HIT)) {
                result += HIT;
                continue;
            }
            char current_char = word.charAt(i);
            if (hash.get(current_char) != null && (Integer) hash.get(current_char) > 0) {
                result += MISS;
                char used_letter = word.charAt(i);
                update_hash(hash, used_letter, -1);
//                hash.put(used_letter, (Integer) hash.get(word.charAt(i)) - 1);
                continue;
            }
            result += NOT_IN_WORD;
        }
        return result;
    }

    private static void update_hash(Dictionary hash, char letter, int i) {
        hash.put(letter, (Integer) hash.get(letter) + i);
    }

    private static String get_hits(Dictionary hash, String hidden_word, String word) {
        String hits = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == hidden_word.charAt(i)) {
                hits += HIT;
                char hit = hidden_word.charAt(i);
                update_hash(hash, hit, -1);
//                hash.put(hidden_word.charAt(i), (Integer) hash.get(hidden_word.charAt(i)) - 1);
            } else hits += " ";
        }
        return hits;
    }

    private static Dictionary count_letters(String word) {
        Dictionary hash = new Hashtable();
        for (int i = 0; i < word.length(); i++) {
            if (hash.get(word.charAt(i)) == null) {
                hash.put(word.charAt(i), 1);
            } else {
                update_hash(hash, word.charAt(i), 1);
            }
        }
        return hash;
    }

    private static boolean validate_same_length(String hidden_word, String word) {
        return hidden_word.length() == word.length();
    }
}
