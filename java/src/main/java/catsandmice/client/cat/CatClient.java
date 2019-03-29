package catsandmice.client.cat;

import catsandmice.client.Client;
import catsandmice.model.Cat;

public interface CatClient extends Client {

    /**
     * Stores the cat with witch the client plays
     *
     * @param cat the cat to play with
     */
    void setCat(Cat cat);

    /**
     * Is called if a new frame has been determined.
     *
     * @param view the current view of the world for the cat
     */
    void render(CatView view);
}
