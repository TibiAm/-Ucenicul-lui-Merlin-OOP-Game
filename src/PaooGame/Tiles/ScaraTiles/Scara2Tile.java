package PaooGame.Tiles.ScaraTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Scara2Tile extends Tile{
    public Scara2Tile(int id)
    {
        super(Assets.scara2, id);
    }
    @Override
    public boolean OnLadder() {
        return true;
    }
}