package catsandmice.client.mouse;

import catsandmice.command.Command;
import catsandmice.engine.Config;
import catsandmice.model.Mouse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MouseNetworkClientClient implements MouseClient {

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private MouseUserClient mouseUserClient;

    public MouseNetworkClientClient(Socket socket, ObjectOutputStream outputStream, ObjectInputStream inputStream, Config config) {
        this.mouseUserClient = new MouseUserClient(config);
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
    public void setMouse(Mouse mouse) {
        mouseUserClient.setMouse(mouse);
    }

    @Override
    public void render(MouseView view) {
        mouseUserClient.render(view);
    }

    @Override
    public Command getNextMove() {
        return mouseUserClient.getNextMove();
    }

    @Override
    public void gameOver(String winner) {
        mouseUserClient.gameOver(winner);
    }

    private boolean handleRequest(Object request) throws IOException {
        if (request instanceof MouseView) {
            render((MouseView) request);
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
