package wordle_server;

public class GuessResult {
    private final String result;

    public GuessResult(String res) {
        this.result = res;
    }

    public String getResult() {
        return result;
    }

}
