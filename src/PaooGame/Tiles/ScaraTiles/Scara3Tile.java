package PaooGame.Tiles.ScaraTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Scara3Tile extends Tile{
    public Scara3Tile(int id)
    {
        super(Assets.scara3, id);
    }
    @Override
    public boolean OnLadder() {
        return true;
    }
}
