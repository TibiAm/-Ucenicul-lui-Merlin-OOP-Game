package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Land2SolidTile extends Tile{
    public Land2SolidTile(int id)
    {
        super(Assets.land2,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
