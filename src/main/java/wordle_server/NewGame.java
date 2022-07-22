package wordle_server;

public class NewGame {
    private final int num_of_letters;
//    private final String game_id;

    public NewGame(String id, int num_of_letters) {
        this.num_of_letters = num_of_letters;
//        this.game_id = id;
    }

//    public String getGameId() {
//        return game_id;
//    }

    public int getNumOfLetters() {
        return num_of_letters;
    }
}
