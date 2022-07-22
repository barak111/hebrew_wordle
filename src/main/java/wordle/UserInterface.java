package wordle;

public interface UserInterface {

    void print_message(String s);

    String enter_word();

    String choose_user();

    String get_word(int word_length);

    void publish_results(String result);

    void end_of_turn(Boolean word_found, Boolean game_over, int i);
}
