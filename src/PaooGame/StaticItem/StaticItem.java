package PaooGame.StaticItem;
import PaooGame.Items.Item;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public abstract class StaticItem extends Item{
    public StaticItem(RefLinks refLink,float x, float y, int width, int height) {
        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }
}
