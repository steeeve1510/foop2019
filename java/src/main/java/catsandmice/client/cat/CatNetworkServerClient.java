package catsandmice.client.cat;

import catsandmice.command.*;
import catsandmice.model.Cat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CatNetworkServerClient implements CatClient {

    private Cat cat;

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public CatNetworkServerClient(Socket socket) {
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeObject("CAT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        try {
            outputStream.writeObject(view);
        } catch (IOException ignored) {
        }
    }

    @Override
    public Command getNextMove() {
        Command nextMove = null;
        try {
            outputStream.writeObject("NEXT_MOVE");
            nextMove = (Command) inputStream.readObject();
        } catch (IOException | ClassNotFoundException ignored) {
        }

        if (nextMove instanceof MoveUpCommand) {
            return new MoveUpCommand(cat);
        }
        if (nextMove instanceof MoveRightCommand) {
            return new MoveRightCommand(cat);
        }
        if (nextMove instanceof MoveDownCommand) {
            return new MoveDownCommand(cat);
        }
        if (nextMove instanceof MoveLeftCommand) {
            return new MoveLeftCommand(cat);
        }
        return null;
    }

    @Override
    public void gameOver(String winner) {
        try {
            outputStream.writeObject(winner);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException ignored) {
        }
    }
}
