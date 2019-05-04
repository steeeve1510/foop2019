package catsandmice;

import catsandmice.client.cat.CatNetworkClientClient;
import catsandmice.engine.Config;

import java.io.IOException;
import java.net.Socket;

public class AppNetwork {

    public static void main(String[] args) {
        // create config of the game
        Config config = new Config();
        try {
            var socket = new Socket("localhost", config.getPort());
            var networkClientClient = new CatNetworkClientClient(socket, config);
            networkClientClient.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
