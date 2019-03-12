package jonahshader.game.menu.mainmenuactions;

import com.badlogic.gdx.Gdx;
import jonahshader.game.menu.Action;

public class ExitGameAction implements Action {
    @Override
    public void executeAction() {
        Gdx.app.exit();
    }
}
