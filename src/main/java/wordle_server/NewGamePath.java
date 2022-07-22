package wordle_server;

public class NewGamePath {
    private final String game_id;
    private final String url;

    public NewGamePath(String id, String url) {
        this.game_id = id;
        this.url = url;
    }

    public String getGameId() {
        return game_id;
    }

    public String getUrl() {
        return url;
    }
}
