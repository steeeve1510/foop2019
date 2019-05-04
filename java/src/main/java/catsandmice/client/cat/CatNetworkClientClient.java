package catsandmice.client.cat;

import catsandmice.command.Command;
import catsandmice.engine.Config;
import catsandmice.model.Cat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CatNetworkClientClient implements CatClient {

    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    private CatUserClient catUserClient;

    public CatNetworkClientClient(Socket socket, Config config) {
        catUserClient = new CatUserClient(config);

        this.socket = socket;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (socket.isConnected()) {
                Object request = objectInputStream.readObject();
                if (request instanceof CatView) {
                    render((CatView) request);
                } else if (request instanceof String) {
                    String stringRequest = (String) request;
                    if ("NEXT_MOVE".equals(stringRequest)) {
                        Command nextMove = getNextMove();
                        objectOutputStream.writeObject(nextMove);
                    } else {
                        gameOver(stringRequest);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    @Override
    public void setCat(Cat cat) {
        catUserClient.setCat(cat);
    }

    @Override
    public void render(CatView view) {
        catUserClient.render(view);
    }

    @Override
    public Command getNextMove() {
        return catUserClient.getNextMove();
    }

    @Override
    public void gameOver(String winner) {
        catUserClient.gameOver(winner);
    }
}
