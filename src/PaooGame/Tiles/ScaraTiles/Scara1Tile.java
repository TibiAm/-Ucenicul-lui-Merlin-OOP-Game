package PaooGame.Tiles.ScaraTiles;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

public class Scara1Tile extends Tile{
    public Scara1Tile(int id)
    {
        super(Assets.scara1, id);
    }
    @Override
    public boolean OnLadder() {
        return true;
    }
}
