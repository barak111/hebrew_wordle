package wordle;

import java.io.IOException;

public class GameManagement {
    UserInterface UI;
    DBUtil db;
    public GameManagement(){
        UI = new TerminalUser();
        db = new file_db();
    }
    public void run() throws IOException {
        String user_type = null;
        do {
            user_type = choose_user();
            switch (user_type) {
                case "1":
                    admin_actions();
                    break;
                case "2":
                    start_playing();
                    break;
                case "3":
                    exit_game();
                    break;
                default:
                    UI.print_message("שגיאה אחי. למה אתה מתחכם. אמרו או '1' או '2' או '3'");
            }
        }while (user_type != "3");

    }

    private void exit_game() {
        UI.print_message("יאללה ביי...");
        System.exit(0);
    }

    private String choose_user() {
        String user = UI.choose_user();
        return user;
    }

    private void admin_actions() throws IOException {
        AdminActions admin_acts = new AdminActions();
        admin_acts.add_words();
    }

    private void start_playing() {
        String game_word = db.get_word_from_words_db();
        Game game = new Game(game_word);
        game.start_game();
    }
}
