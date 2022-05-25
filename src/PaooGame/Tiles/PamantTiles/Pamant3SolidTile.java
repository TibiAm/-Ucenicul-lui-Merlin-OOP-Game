package PaooGame.Tiles.PamantTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Pamant3SolidTile extends Tile {
    public Pamant3SolidTile(int id)
    {
        super(Assets.soil3,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
