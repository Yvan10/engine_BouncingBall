package MovingRectangleGame;

import engine.Buffer;
import engine.Game;
import engine.control.MouvementController;

public class MovingRectangleGame extends Game {
    private MouvementController inputHandler;
    private Player player;
    @Override
    public void initialize() {
        inputHandler = new MouvementController();
        addKeyListener(inputHandler);
        player = new Player(inputHandler);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Buffer buffer) {
        player.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
