package wordle_server;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import wordle.file_db;

@RestController
public class NewGameController {
    private static final String url = "localhost:8080/new_game";
//    private static final String id = UUID.randomUUID().toString();

    private final file_db  db_utils = new file_db();

    @PostMapping("/new_game")
    public NewGamePath init_new_game(@RequestParam(value = "word", defaultValue = "aluma") String word) throws IOException {
        String id = UUID.randomUUID().toString();
        db_utils.push_game_to_db(id, word);
        return new NewGamePath(id, url + "/" + id);
    }

    @GetMapping("/new_game/{id}")
    public NewGame get_num_of_letters(@PathVariable String id, @RequestParam(value = "word", defaultValue = "---") String word) throws IOException {
        String chosenWord = db_utils.get_word_of_game_from_db(id);
        if (chosenWord == null){
            throw new NoSuchElementException(id);
        }
        int numOfLetters = chosenWord.length();
        return new NewGame(id, numOfLetters);
    }
}
