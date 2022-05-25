package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Sol2SolidTile extends Tile{
    public Sol2SolidTile(int id)
    {
        super(Assets.sol2,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}