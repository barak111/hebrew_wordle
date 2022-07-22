package wordle;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class file_db implements DBUtil {
    String  words_db_file;
    String  games_db_file;
    UserInterface UI;
    Random rand;
    public file_db(){
        UI = new TerminalUser();
        words_db_file = "db/words.txt";
        games_db_file = "db/games.txt";
        rand = new Random();
    }
    @Override
    public void push_word_to_db(String word) throws IOException {
        try (FileWriter f = new FileWriter(words_db_file, true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);)
        {
            UI.print_message("דוחף את המילה \"" + word + "\"");
            p.println(word);
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }

    @Override
    public void push_game_to_db(String id, String secret_word) throws IOException {
        try (FileWriter f = new FileWriter(games_db_file, true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);)
        {
            UI.print_message("דוחף את המשחק \"" + id + "\"");
            p.println(id + "@" + secret_word);
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }

    @Override
    public String get_word_of_game_from_db(String id) {
        String[] arr_games = get_all_data(games_db_file);
        String game_id;
        String secret_word;
        for (String game : arr_games) {
            System.out.println(game);
            game_id = game.split("@")[0];
            System.out.println(game_id);
            secret_word = game.split("@")[1];
            System.out.println(secret_word);
            if (game_id.equals(id)) {
                return secret_word;
            }
        }
        System.out.println("return nullllllll");
        return null;
//            UI.print_message(w);
    }

    private String[] get_all_data(String db_file) {
        String data = null;
        try {
            File my_db_file = new File(db_file);
            Scanner myReader = new Scanner(my_db_file);
            while (myReader.hasNextLine()) {
                data += " " + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            UI.print_message("אירעה שגיאה בקריאה מהקובץ");
            e.printStackTrace();
        }
        String[] all_elements = data.split(" ");
        return removeFirstElement(all_elements);
    }


    @Override
    public String get_word_from_words_db() {
        String[] arr_words = get_all_data(words_db_file);
        return arr_words[rand.nextInt(arr_words.length)];
    }


    private String[] removeFirstElement(String [] arr) {
        String newArr[] = new String[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            newArr[i-1] = arr[i];
        }
        return newArr;
    }
//    private String[] get_all_words() {
//        String data = null;
//        try {
//            File my_db_file = new File(words_db_file);
//            Scanner myReader = new Scanner(my_db_file);
//            while (myReader.hasNextLine()) {
//                data += " " + myReader.nextLine();
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            UI.print_message("אירעה שגיאה בקריאה מהקובץ");
//            e.printStackTrace();
//        }
//        String[] all_words = data.split(" ");
//        return removeFirstElement(all_words);
//    }


    @Override
    public void print_all_db() {
        String[] arr_words = get_all_data(words_db_file);
        for (String w : arr_words)
            UI.print_message(w);
    }
}
