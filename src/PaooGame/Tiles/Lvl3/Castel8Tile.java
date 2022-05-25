package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Castel8Tile extends Tile{
    public Castel8Tile(int id)
    {
        super(Assets.castel8,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}