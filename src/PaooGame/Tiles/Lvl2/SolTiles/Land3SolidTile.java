package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Land3SolidTile extends Tile{
    public Land3SolidTile(int id)
    {
        super(Assets.land3,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
