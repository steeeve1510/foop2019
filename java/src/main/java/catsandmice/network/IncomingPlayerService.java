package catsandmice.network;

import catsandmice.engine.Config;
import catsandmice.model.Game;
import catsandmice.model.Player;

import java.util.HashSet;
import java.util.Set;

public class IncomingPlayerService {

    private Config config;
    private Game game;

    private final Object newPlayersLock = new Object();
    private Set<Player> newPlayers = new HashSet<>();

    private IncomingPlayerListener listeningThread;

    public IncomingPlayerService(Config config, Game game) {
        this.config = config;
        this.game = game;
    }

    public void start() {
        listeningThread = new IncomingPlayerListener(this, config, game);
        Thread worker = new Thread(listeningThread);
        worker.start();
    }

    public void stop() {
        if (listeningThread != null) {
            listeningThread.stop();
        }
    }

    void addNewPlayer(Player player) {
        synchronized (newPlayersLock) {
            newPlayers.add(player);
        }
    }

    public Set<Player> getNewPlayers() {
        synchronized (newPlayersLock) {
            var newPlayersCopy = newPlayers;
            newPlayers = new HashSet<>();
            return newPlayersCopy;
        }
    }
}
