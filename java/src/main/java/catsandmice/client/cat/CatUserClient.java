package catsandmice.client.cat;

import catsandmice.client.JavaFXUI;
import catsandmice.command.*;
import catsandmice.engine.Config;
import catsandmice.model.Cat;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

import static catsandmice.client.JavaFXUI.forEveryField;
import static catsandmice.client.JavaFXUI.getField;

/**
 * The GUI implementation of a cat
 */
public class CatUserClient implements CatClient {

    private Cat cat;
    private boolean launched = false;
    private Command nextCommand;

    private JavaFXUI.ElementHolder elements = new JavaFXUI.ElementHolder();

    public CatUserClient(Config config) {
        elements.config = config;
    }

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        if (!launched) {
            elements.keyEvent = this.getKeyEventHandler();
            elements.pane = new FlowPane();
            var ui = new JavaFXUI(elements);
            var thread = new Thread(ui);
            thread.start();
            launched = true;
        }

        forEveryField((coordinate -> {
            final var fieldConfig = new JavaFXUI.FieldConfig();
            if (view.getCurrentPosition().getCoordinate().equals(coordinate)) {
                fieldConfig.text = "C";
                fieldConfig.color = "red";
            } else if (view.getCats().contains(coordinate)) {
                fieldConfig.text = "C";
            } else if (view.getMice().contains(coordinate)) {
                fieldConfig.text = "M";
            } else if (view.getDeadMice().contains(coordinate)) {
                fieldConfig.text = "M";
                fieldConfig.color = "gray";
            } else if (view.getEntrances().contains(coordinate)) {
                fieldConfig.text = "O";
                fieldConfig.color = "gray";
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

    private EventHandler<KeyEvent> getKeyEventHandler() {
        return (keyEvent) -> {
            switch (keyEvent.getCode()) {
                case UP:
                    nextCommand = new MoveUpCommand(cat);
                    break;
                case RIGHT:
                    nextCommand = new MoveRightCommand(cat);
                    break;
                case DOWN:
                    nextCommand = new MoveDownCommand(cat);
                    break;
                case LEFT:
                    nextCommand = new MoveLeftCommand(cat);
                    break;
            }
        };
    }
}