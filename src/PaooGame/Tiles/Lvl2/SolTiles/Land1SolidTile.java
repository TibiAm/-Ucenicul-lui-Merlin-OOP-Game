package PaooGame.Tiles.Lvl2.SolTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Land1SolidTile extends Tile{
    public Land1SolidTile(int id)
    {
        super(Assets.land1,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
