package catsandmice.client.mouse;

import catsandmice.command.Command;
import catsandmice.command.MoveDownCommand;
import catsandmice.command.MoveRightCommand;
import catsandmice.command.mouse.*;
import catsandmice.model.Mouse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MouseNetworkServerClient implements MouseClient {

    private Mouse mouse;

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private MouseView lastView;

    public MouseNetworkServerClient(Socket socket) {
        try {
            this.socket = socket;
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeObject("MOUSE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public void render(MouseView view) {
        this.lastView = view;
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

        if (nextMove instanceof MouseMoveUpCommand) {
            return new MouseMoveUpCommand(mouse);
        }
        if (nextMove instanceof MouseMoveRightCommand) {
            return new MoveRightCommand(mouse);
        }
        if (nextMove instanceof MouseMoveDownCommand) {
            return new MoveDownCommand(mouse);
        }
        if (nextMove instanceof MouseMoveLeftCommand) {
            return new MouseMoveLeftCommand(mouse);
        }
        if (nextMove instanceof ToggleLayerCommand) {
            var toggle = new ToggleLayerCommand(mouse);
            toggle.initialize(lastView.getCats());
            return toggle;
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
