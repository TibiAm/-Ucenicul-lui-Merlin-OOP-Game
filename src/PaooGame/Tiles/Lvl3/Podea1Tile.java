package PaooGame.Tiles.Lvl3;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Podea1Tile extends Tile{
    public Podea1Tile(int id)
    {
        super(Assets.podea1,id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}