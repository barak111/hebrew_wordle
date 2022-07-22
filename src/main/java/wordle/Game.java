package wordle;

public class Game {
    String hidden_word;
    int word_length;
    int num_of_tries;
    Boolean word_found;
    Boolean game_over;
    UserInterface UI;

    public Game(String word){
        hidden_word = word;
        word_length = hidden_word.length();
        num_of_tries = 0;
        word_found = false;
        game_over = false;
        UI = new TerminalUser();
    }
    public void start_game() {
        while(!word_found && !game_over){
            turn();
//            num_of_tries++;
        }
    }

    private void turn() {
        try {
            String word = UI.get_word(word_length);
            String result = Utils.check_word(hidden_word, word);
            UI.publish_results(result);
            check_results(result);
            UI.end_of_turn(word_found, game_over, ++num_of_tries);
        }catch (Exception e){
            UI.print_message("שגיאה: " + e);
        }
    }

    private void check_results(String result) {
        if (result.length() == word_length){
            if(result.replaceAll("\\" + Utils.HIT, "").length() == 0){
                word_found =true;
            }
        }

    }
}
