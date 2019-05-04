package catsandmice.client.cat;

import catsandmice.command.*;
import catsandmice.model.Cat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CatNetworkServerClient implements CatClient {

    private Cat cat;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public CatNetworkServerClient(Socket socket) {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Command getNextMove() {
        Command nextMove = null;
        try {
            outputStream.writeObject("NEXT_MOVE");
            nextMove = (Command) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
