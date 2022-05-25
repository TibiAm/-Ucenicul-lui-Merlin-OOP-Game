package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Castel6Tile extends Tile{
    public Castel6Tile(int id)
    {
        super(Assets.castel6,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
