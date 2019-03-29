package catsandmice.client.mouse;

import catsandmice.client.Client;
import catsandmice.model.Mouse;

public interface MouseClient extends Client {

    /**
     * Stores the mouse with witch the client plays
     *
     * @param mouse the mouse to play with
     */
    void setMouse(Mouse mouse);

    /**
     * Is called if a new frame has been determined.
     *
     * @param view the current view of the world for the mouse
     */
    void render(MouseView view);
}
