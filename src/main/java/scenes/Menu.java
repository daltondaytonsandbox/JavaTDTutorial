package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;

public class Menu extends GameScene implements SceneMethods {

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    /**
     * @Summary Takes the game class and sends it to GameScene to be stored.
     * @param game The game class
     */
    public Menu(Game game) {
        super(game);
        random = new Random();
        importImg();
        loadSprites();
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRndInt(100)), x * 32, y * 32, null);
            }
        }
    }

    /**
     * @Summary Imports the sprite sheet
     */
    private void importImg() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Summary Loads the sprites from the imported image into an ArrayList
     */
    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    /**
     * @Summary Generates a random int
     * @param x The upper limit
     * @return A randomly generated int
     */
    private int getRndInt(int x) {
        return random.nextInt(x);
    }
}
