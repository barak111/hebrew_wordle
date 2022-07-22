package wordle;

import java.util.Scanner;

public class TerminalUser implements UserInterface {
    @Override
    public void print_message(String s) {
        System.out.println(s);
    }

    @Override
    public String enter_word() {
        Scanner sc= new Scanner(System.in);
        print_message("הכנס מילה: ");
        return sc.next();
    }

    @Override
    public String choose_user() {
        Scanner sc= new Scanner(System.in);
        print_message("הקלד '1' להכנסת מילה, \n '2' כדי לשחק \n '3' כדי לצאת: ");
        return sc.next();
    }

    @Override
    public String get_word(int word_length) {
        Scanner sc= new Scanner(System.in);
        print_message("הכנס מילה (באורך של " + word_length + " אותיות): ");
        return sc.next();
    }

    @Override
    public void publish_results(String result) {
        print_message("התוצאה: " + result);
    }

    @Override
    public void end_of_turn(Boolean word_found, Boolean game_over, int i) {
        if (!word_found && !game_over){
            print_message("עברו " + i + " תורות. נסה עוד פעם.. ");
        }
        else if(word_found){
            print_message("יששששש!!! ניצחת תוך " + i + " תורות!!");
            print_message("---------------------------------------------------");
            print_message("\n\nרוצה לשחק שוב??");
        }
    }
}
