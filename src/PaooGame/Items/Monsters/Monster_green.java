package PaooGame.Items.Monsters;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Character;
import PaooGame.RefLinks;

public class Monster_green extends Monster {

    public Monster_green(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT,
                Assets.monster_drt[5]);


    }


    @Override
    public void die() {

    }


}
