package catsandmice.client.cat;

import catsandmice.command.Command;
import catsandmice.command.MoveUpCommand;
import catsandmice.model.Cat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The GUI implementation of a cat
 */
public class CatUserClient extends Application implements CatClient, Runnable {

    private Cat cat;
    private boolean launched = false;

    public CatUserClient() {
    }

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void render(CatView view) {
        if (!launched) {
            Thread thread = new Thread(this);
            thread.start();
            launched = true;
        }
        System.out.println(view.getCurrentPosition().getCoordinate());
    }

    @Override
    public Command getNextMove() {
        return new MoveUpCommand(cat);
    }

    @Override
    public void gameOver(String winner) {
        System.out.println("GAME OVER!\nThe winner is: " + winner);
    }

    @Override
    public void run() {
        launch();
    }
}
