package catsandmice.client.mouse;

import catsandmice.client.JavaFXUI;
import catsandmice.command.Command;
import catsandmice.command.mouse.*;
import catsandmice.engine.Config;
import catsandmice.model.Coordinate;
import catsandmice.model.Mouse;
import catsandmice.model.Subway;
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
        if (!launched) {
            elements.pane = new FlowPane();
            var ui = new JavaFXUI(elements);
            var thread = new Thread(ui);
            thread.start();
            launched = true;
        }
        elements.keyEvent = this.getKeyEventHandler(view);

        Set<Coordinate> entrances = view.getSubways().stream()
                .flatMap(s -> s.getEntrances().stream())
                .collect(Collectors.toSet());
        forEveryField((coordinate -> {
            final var fieldConfig = new JavaFXUI.FieldConfig();
            if (view.getCurrentPosition().getLayer() instanceof Subway) {
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
            } else if (entrances.contains(coordinate)) {
                fieldConfig.text = "O";
                fieldConfig.color = "dimgray";
            }
            return getField(fieldConfig);
        }));
    }

    @Override
    public Command getNextMove() {
        return nextCommand;
    }

    @Override
    public void gameOver(String winner) {
        JavaFXUI.gameOver(winner);
    }

    private EventHandler<KeyEvent> getKeyEventHandler(MouseView mouseView) {
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
                    nextCommand = new ToggleLayerCommand(mouse, mouseView.getCats());
            }
        };
    }
}
