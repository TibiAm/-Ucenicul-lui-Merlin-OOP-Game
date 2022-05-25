package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Castel7Tile extends Tile{
    public Castel7Tile(int id)
    {
        super(Assets.castel7,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
