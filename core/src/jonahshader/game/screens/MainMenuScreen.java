package jonahshader.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import jonahshader.game.FontManager;
import jonahshader.game.RTSGame;
import jonahshader.game.menu.Menu;
import jonahshader.game.menu.mainmenuactions.ExitGameAction;
import jonahshader.game.menu.mainmenuactions.PlayGameAction;
import jonahshader.game.menu.mainmenuactions.SettingsAction;

public class MainMenuScreen implements Screen {
    public static final int WORLD_WIDTH = 1920;
    public static final int WORLD_HEIGHT = 1080;

    final RTSGame game;
    final SpriteBatch batch;
    final ShapeRenderer shapeBatch;

    private Menu mainMenu;

    private Viewport viewport;

    private BitmapFont titleFont, mainFont;

    public MainMenuScreen(RTSGame game) {
        // pass parameters
        this.game = game;
        batch = game.batch;
        shapeBatch = game.shapeBatch;

        // construct objects
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        viewport.getCamera().position.x = WORLD_WIDTH / 2f;
        viewport.getCamera().position.y = WORLD_HEIGHT / 2f;
        batch.setProjectionMatrix(viewport.getCamera().combined);
        shapeBatch.setProjectionMatrix(viewport.getCamera().combined);

        // generate fonts
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 148;
        titleFont = game.fontManager.generateFont(FontManager.FontType.Title, param);
        titleFont.getData().setScale(1/2.0f);
        titleFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = 108;
        mainFont = game.fontManager.generateFont(FontManager.FontType.Main, param);
        mainFont.getData().setScale(1/2.0f);
        mainFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mainMenu = new Menu(mainFont, 78, WORLD_HEIGHT - 300, (108 / 2f) * 1.5f, batch, shapeBatch, viewport);
        mainMenu.addMenuItem(new PlayGameAction(), "Play Game");
        mainMenu.addMenuItem(new SettingsAction(), "Settings");
        mainMenu.addMenuItem(new ExitGameAction(), "Exit");

        // set input processor to the menu
        Gdx.input.setInputProcessor(mainMenu);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // do calculations first
        mainMenu.run(delta);

        // render
        batch.begin();
        mainMenu.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height); // inform viewport on window size change.
        // recalculates the viewport parameters and automatically updates camera.

        batch.setProjectionMatrix(viewport.getCamera().combined);
        shapeBatch.setProjectionMatrix(viewport.getCamera().combined);
        System.out.println(viewport.getCamera());
//        viewport.getCamera()
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
