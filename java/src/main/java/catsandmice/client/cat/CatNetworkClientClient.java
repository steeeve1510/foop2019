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
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private CatUserClient catUserClient;

    public CatNetworkClientClient(Socket socket, ObjectOutputStream outputStream, ObjectInputStream inputStream, Config config) {
        catUserClient = new CatUserClient(config);
        this.socket = socket;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    public void run() {
        while (socket.isConnected()) {
            try {
                var request = inputStream.readObject();
                var stop = handleRequest(request);
                if (stop) {
                    break;
                }
            } catch (IOException | ClassNotFoundException ignored) {
            }
        }

        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    private boolean handleRequest(Object request) throws IOException {
        if (request instanceof CatView) {
            render((CatView) request);
            return false;
        }

        if (request instanceof String && "NEXT_MOVE".equals(request)) {
            var nextMove = getNextMove();
            outputStream.writeObject(nextMove);
            return false;
        }

        if (request instanceof String) {
            var stringRequest = (String) request;
            gameOver(stringRequest);
            return true;
        }

        return false;
    }
}
