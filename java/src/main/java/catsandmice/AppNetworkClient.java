package catsandmice;

import catsandmice.client.cat.CatNetworkClientClient;
import catsandmice.client.mouse.MouseNetworkClientClient;
import catsandmice.engine.Config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppNetworkClient {

    public static void main(String[] args) {
        // create config of the game
        Config config = new Config();
        try {
            var socket = new Socket("localhost", config.getPort());

            var outputStream = new ObjectOutputStream(socket.getOutputStream());
            var inputStream = new ObjectInputStream(socket.getInputStream());
            var type = inputStream.readObject();
            if ("CAT".equals(type)) {
                var networkClientClient = new CatNetworkClientClient(socket, outputStream, inputStream, config);
                networkClientClient.run();
            } else if ("MOUSE".equals(type)) {
                var networkClientClient = new MouseNetworkClientClient(socket, outputStream, inputStream, config);
                networkClientClient.run();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
