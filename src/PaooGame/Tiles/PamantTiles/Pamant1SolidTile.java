package PaooGame.Tiles.PamantTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Pamant1SolidTile extends Tile {
    public Pamant1SolidTile(int id)
    {
        super(Assets.soil1,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
