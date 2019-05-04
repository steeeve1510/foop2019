package catsandmice.network;

import catsandmice.client.cat.CatNetworkServerClient;
import catsandmice.client.mouse.MouseNetworkServerClient;
import catsandmice.engine.Config;
import catsandmice.engine.Initializer;
import catsandmice.model.Cat;
import catsandmice.model.Game;
import catsandmice.model.Mouse;
import catsandmice.model.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;

public class IncomingPlayerListener implements Runnable {

    private static IncomingPlayerService incomingPlayerService;
    private static Config config;
    private static Game game;

    private volatile ServerSocket serverSocket;

    IncomingPlayerListener(IncomingPlayerService incomingPlayerService, Config config, Game game) {
        IncomingPlayerListener.incomingPlayerService = incomingPlayerService;
        IncomingPlayerListener.config = config;
        IncomingPlayerListener.game = game;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(config.getPort());
            while (true) {
                var socket = serverSocket.accept();
                var player = createPlayer(socket);
                incomingPlayerService.addNewPlayer(player);
            }
        } catch (IOException ignored) {
        }
    }

    Player createPlayer(Socket socket) {
        var random = Math.random();
        if (random < 0.5) {
            return createCat(socket);
        } else {
            return createMouse(socket);
        }
    }

    void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cat createCat(Socket socket) {
        var networkClient = new CatNetworkServerClient(socket);
        var position = Initializer.getNewCatPosition(config, game.getBoard().getSurface());
        return new Cat(networkClient, position);
    }

    private Mouse createMouse(Socket socket) {
        var netWorkClient = new MouseNetworkServerClient(socket);
        var subways = game.getBoard().getSubways();
        var goalSubway = game.getGoalSubway();
        var subwaysWithoutGoal = subways.stream()
                .filter(s -> s != goalSubway)
                .collect(Collectors.toSet());
        var position = Initializer.getNewMousePosition(config, subwaysWithoutGoal);
        return new Mouse(netWorkClient, position);
    }
}
