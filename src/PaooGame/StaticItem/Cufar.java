package PaooGame.StaticItem;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Cufar extends StaticItem{


    public Cufar(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);

        bounds.x=0;
        bounds.y=10;
        bounds.width=48;
        bounds.height=38;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.cufar,(int)(x),(int)(y),width,height,null);
    }

    @Override
    public void die() {
        refLink.GetMap().getElementManager().addElement(Element.bluecristal.CreateNew((int)(x),(int)(y)));
        refLink.GetMap().getElementManager().addElement(Element.cristalroz.CreateNew((int)(x),(int)(y)));
    }
}