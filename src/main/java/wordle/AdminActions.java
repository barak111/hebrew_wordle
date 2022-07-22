package wordle;

import java.io.IOException;

public class AdminActions {
    UserInterface UI;
    DBUtil db;
    public AdminActions(){
        UI = new TerminalUser();
        db = new file_db();
    }
    public void add_words() throws IOException {
        String word = UI.enter_word();
        db.push_word_to_db(word);
        UI.print_message("המילה נקלטה");
//        UI.print_message("עכשיו יש בדאטה בייס:");
//        db.print_all_db();
    }
}
