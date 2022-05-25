package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Sol3SolidTile extends Tile{
    public Sol3SolidTile(int id)
    {
        super(Assets.sol3,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
