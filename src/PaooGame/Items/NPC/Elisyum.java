package PaooGame.Items.NPC;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Hero;
import PaooGame.MyException;
import PaooGame.RefLinks;
import PaooGame.States.Levels.LevelFlags;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class Elisyum extends NPC{

    private Rectangle DetectionHeroRectangle;
    private boolean HeroDetected=false;

    public Elisyum(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 11;
        bounds.y = 10;
        bounds.width = 25;
        bounds.height = 35;

        image= Assets.calauza;

        DetectionHeroRectangle=new Rectangle((int)x-(Tile.TILE_WIDTH/2),(int)y-Tile.TILE_HEIGHT,5*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT);

    }

    @Override
    public void Update() {

        HeroDetected= refLink.GetMap().getItemManager().getHero().getCollisionsBounds(0, 0).intersects(DetectionHeroRectangle);

    }

    @Override
    public void Draw(Graphics g) {

        g.drawImage(image,(int)(x),(int)(y),width,height,null);

        if(HeroDetected)
            g.drawImage(Assets.mesajcalauza,(int)x- Tile.TILE_WIDTH,(int)y-Tile.TILE_HEIGHT,null);

    }

    @Override
    public void die() {

    }

    public void Interact() throws MyException{

        ArrayList<Element> elements= Hero.getStorage().getStorageElements();
        for(Element e : elements) {
            if(e.getId()==0)
            {
                if(e.getCount()>=5)
                {
                    e.setCount(e.getCount()-5);
                    active=false;
                    if(LevelFlags.level1_passed())
                        LevelFlags.level2_part1_coinsPaid=true;
                        LevelFlags.level1_part1_coinsPaid=true;
                }
                else
                {
                    throw new MyException("Nu ai sufiecnte toteme pentru a-i da lui Elisyum");
                }
            }
        }
    }

}
