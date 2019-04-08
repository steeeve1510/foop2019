package catsandmice.client.cat;

import catsandmice.client.JavaFXUI;
import catsandmice.command.*;
import catsandmice.engine.Config;
import catsandmice.model.Cat;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import static catsandmice.client.JavaFXUI.forEveryField;

/**
 * The GUI implementation of a cat
 */
public class CatUserClient implements CatClient {

    private Config config;

    private Cat cat;
    private boolean launched = false;
    private Command nextCommand;

    private JavaFXUI.ElementHolder elements = new JavaFXUI.ElementHolder();

    public CatUserClient(Config config) {
        this.config = config;
        elements.config = config;
    }

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        nextCommand = null;
        if (!launched) {
            elements.keyEvent = (keyEvent) -> {
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
            elements.pane = new FlowPane();
            var ui = new JavaFXUI(elements);
            var thread = new Thread(ui);
            thread.start();
            launched = true;
        }

        forEveryField((coordinate -> {
            final var fieldConfig = new FieldConfig();
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

    private Pane getField(FieldConfig fieldConfig) {
        int canvasWidth = elements.config.getWindowWidth() / elements.config.getWidth() - 1;
        int canvasHeight = elements.config.getWindowHeight() / elements.config.getHeight() - 1;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        Label label = new Label(fieldConfig.text);
        label.setTextFill(Color.web(fieldConfig.color));

        StackPane holder = new StackPane();
        holder.getChildren().add(canvas);
        holder.getChildren().add(label);
        holder.setStyle(
                "-fx-background-color: white; " +
                        "-fx-border-width: 0 1px 1px 0; " +
                        "-fx-border-color: " + fieldConfig.backgroundColor + ";"
        );
        return holder;
    }

    private class FieldConfig {
        String text = "";
        String color = "black";
        String backgroundColor = "lightgray";
    }
}