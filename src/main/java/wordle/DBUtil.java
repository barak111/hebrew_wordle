package wordle;

import java.io.IOException;

public interface DBUtil {
    void push_word_to_db(String word) throws IOException;

    void push_game_to_db(String id, String secret_word) throws IOException;

    String get_word_of_game_from_db(String id);

    String get_word_from_words_db();

    void print_all_db();
}
