package catsandmice.client.mouse;

import catsandmice.client.JavaFXUI;
import catsandmice.command.Command;
import catsandmice.command.mouse.*;
import catsandmice.engine.Config;
import catsandmice.model.Coordinate;
import catsandmice.model.Mouse;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

import java.util.Set;
import java.util.stream.Collectors;

import static catsandmice.client.JavaFXUI.forEveryField;
import static catsandmice.client.JavaFXUI.getField;

/**
 * The GUI implementation of a mouse
 */
public class MouseUserClient implements MouseClient {

    private Mouse mouse;
    private MouseView currentView;
    private boolean launched = false;
    private Command nextCommand;

    private JavaFXUI.ElementHolder elements = new JavaFXUI.ElementHolder();

    public MouseUserClient(Config config) {
        this.elements.config = config;
    }

    @Override
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public void render(MouseView view) {
        currentView = view;
        if (!launched) {
            elements.pane = new FlowPane();
            elements.keyEvent = this.getKeyEventHandler();
            var ui = new JavaFXUI(elements);
            var thread = new Thread(ui);
            thread.start();
            launched = true;
        }

        Set<Coordinate> entrances = view.getSubways().stream()
                .flatMap(s -> s.getEntrances().stream())
                .collect(Collectors.toSet());
        forEveryField((coordinate -> {
            final var fieldConfig = new JavaFXUI.FieldConfig();
            if (!view.getCurrentPosition().isOnSurface()) {
                fieldConfig.backgroundColor = "silver";
            }
            if (view.getCurrentPosition().getCoordinate().equals(coordinate)) {
                fieldConfig.text = "M";
                fieldConfig.color = "red";
            } else if (view.getCats().contains(coordinate)) {
                fieldConfig.text = "C";
            } else if (view.getMice().contains(coordinate)) {
                fieldConfig.text = "M";
            } else if (view.getDeadMice().contains(coordinate)) {
                fieldConfig.text = "m";
                fieldConfig.color = "dimgray";
            } else if (view.getGoalSubway().getEntrances().contains(coordinate) && view.getCurrentPosition().isOnSurface()) {
                fieldConfig.text = "O";
                fieldConfig.color = "red";
            } else if (entrances.contains(coordinate)) {
                fieldConfig.text = "O";
                fieldConfig.color = "dimgray";
            }
            return getField(fieldConfig);
        }));
    }

    @Override
    public Command getNextMove() {
        if (nextCommand instanceof ToggleLayerCommand) {
            ((ToggleLayerCommand) nextCommand).initialize(currentView.getCats());
        }
        return nextCommand;
    }

    @Override
    public void gameOver(String winner) {
        JavaFXUI.gameOver(winner);
    }

    private EventHandler<KeyEvent> getKeyEventHandler() {
        return (keyEvent) -> {
            switch (keyEvent.getCode()) {
                case UP:
                    nextCommand = new MouseMoveUpCommand(mouse);
                    break;
                case RIGHT:
                    nextCommand = new MouseMoveRightCommand(mouse);
                    break;
                case DOWN:
                    nextCommand = new MouseMoveDownCommand(mouse);
                    break;
                case LEFT:
                    nextCommand = new MouseMoveLeftCommand(mouse);
                    break;
                case SPACE:
                    nextCommand = new ToggleLayerCommand(mouse);
            }
        };
    }
}
