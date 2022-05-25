package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class CutieTile extends Tile{
    public CutieTile(int id)
    {
        super(Assets.cutie,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
