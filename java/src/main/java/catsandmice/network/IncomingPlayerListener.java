package catsandmice.network;

import catsandmice.client.cat.CatNetworkServerClient;
import catsandmice.engine.Config;
import catsandmice.model.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        var networkClient = new CatNetworkServerClient(socket);
        var position = new Position(new Coordinate(0, 0), game.getBoard().getSurface());
        return new Cat(networkClient, position);
    }

    void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
