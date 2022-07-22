package wordle_server;

import java.io.IOException;
import java.util.*;
import java.util.function.*;

import com.fasterxml.jackson.databind.exc.InvalidNullException;
import org.apache.tomcat.util.http.fileupload.impl.InvalidContentTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wordle.file_db;
import wordle.Utils;

@RestController
public class Game_controller {
    private final file_db  db_utils = new file_db();
    private final Utils utils = new Utils();


    @GetMapping("/game/{id}")
    public GuessResult get_guess_result(@PathVariable String id, @RequestParam(value = "word") String guess) throws Exception {
        if(guess == null){
            //todo: return failure code
            throw new InvalidContentTypeException();
        }
        String chosenWord = db_utils.get_word_of_game_from_db(id);
        if (chosenWord == null){
            //todo: return failure code
            throw new NoSuchElementException(id);
        }
        String guess_result = utils.check_word(chosenWord, guess);
        return new GuessResult(guess_result);
    }
}
