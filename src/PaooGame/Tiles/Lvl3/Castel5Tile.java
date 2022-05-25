package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Castel5Tile extends Tile{
    public Castel5Tile(int id)
    {
        super(Assets.castel5,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
