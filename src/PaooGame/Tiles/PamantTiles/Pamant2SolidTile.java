package PaooGame.Tiles.PamantTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Pamant2SolidTile extends Tile {
    public Pamant2SolidTile(int id)
    {
        super(Assets.soil2,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}