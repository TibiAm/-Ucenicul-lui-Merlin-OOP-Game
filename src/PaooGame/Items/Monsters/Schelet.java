package PaooGame.Items.Monsters;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Character;
import PaooGame.RefLinks;

public class Schelet extends Monster {

    public Schelet(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT,
                Assets.schelet);
    }

    @Override
    public void die() {

    }


}
