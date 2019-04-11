package catsandmice.client;

import catsandmice.engine.Config;
import catsandmice.model.Coordinate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.Function;

public class JavaFXUI extends Application implements Runnable {
    private static ElementHolder elements;

    public JavaFXUI() {
    }

    public JavaFXUI(ElementHolder elements) {
        JavaFXUI.elements = elements;
    }

    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(elements.pane, elements.config.getWindowWidth(), elements.config.getWindowHeight());
        primaryStage.setScene(scene);
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, elements.keyEvent);
        primaryStage.show();
    }

    public static void forEveryField(Function<Coordinate, Pane> supplier) {
        changeGui(() -> elements.pane.getChildren().clear());
        int width = elements.config.getWidth();
        int height = elements.config.getHeight();

        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                Pane pane = supplier.apply(coordinate);
                changeGui(() -> {
                    elements.pane.getChildren().add(pane);
                });
            }
        }
    }

    public static void changeGui(Runnable runnable) {
        try {
            Platform.runLater(runnable);
        } catch (Exception e) {
        }
    }

    public static void gameOver(String message) {
        changeGui(() -> {
            elements.pane.getChildren().clear();
            Canvas canvas = new Canvas(elements.config.getWindowWidth(), elements.config.getWindowHeight());
            Label label = new Label("GAME OVER!\n" + message);
            Pane holder = new StackPane(canvas, label);
            holder.setStyle(
                    "-fx-background-color: white;"
            );
            elements.pane.getChildren().add(holder);
        });
    }

    public static class ElementHolder {
        public Pane pane;
        public EventHandler<KeyEvent> keyEvent;
        public Config config;
    }


    public static Pane getField(FieldConfig fieldConfig) {
        int canvasWidth = elements.config.getWindowWidth() / elements.config.getWidth() - 1;
        int canvasHeight = elements.config.getWindowHeight() / elements.config.getHeight() - 1;

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        Label label = new Label(fieldConfig.text);
        label.setTextFill(Color.web(fieldConfig.color));

        StackPane holder = new StackPane();
        holder.getChildren().add(canvas);
        holder.getChildren().add(label);
        holder.setStyle(
                "-fx-background-color: " + fieldConfig.backgroundColor + "; " +
                        "-fx-border-width: 0 1px 1px 0; " +
                        "-fx-border-color: gray;"
        );
        return holder;
    }

    public static class FieldConfig {
        public String text = "";
        public String color = "black";
        public String backgroundColor = "white";
    }
}
