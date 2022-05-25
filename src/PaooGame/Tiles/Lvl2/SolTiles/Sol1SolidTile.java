package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Sol1SolidTile extends Tile{
    public Sol1SolidTile(int id)
    {
        super(Assets.sol1,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
