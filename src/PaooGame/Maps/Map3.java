package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Monsters.*;
import PaooGame.Items.NPC.*;
import PaooGame.RefLinks;
import PaooGame.States.LoseState;
import PaooGame.States.State;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;
import PaooGame.StaticItem.*;
import java.awt.*;
import java.sql.SQLException;

public class Map3 extends Map{
    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel2_1.txt",
            "res/Mapa/MapaLevel2_2.txt",
            "res/Mapa/MapaLevel2_3.txt"
    };
    public Map3(RefLinks links) {

        super(paths, links);
        background= ImageLoader.LoadImage("/textures/Background2.png");

        itemManager.addItem((new Elisyum(refLink,14*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT)));
        itemManager.addItem((new Cufar(refLink,9*Tile.TILE_WIDTH, 4*Tile.TILE_HEIGHT)));
        itemManager.addItem((new Schelet(refLink,8*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT)));
        itemManager.addItem((new Schelet(refLink,0*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT)));

        elementsToBeRefreshed.add(Element.totem.CreateNew(1*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,0*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(7*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(9*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(13*Tile.TILE_WIDTH,0*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(4*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(12*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(8*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(6*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(9*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));

        Refresh();
    }

    @Override
    public void Update()
    {
        super.Update();
        Rectangle lava=new Rectangle(3*Tile.TILE_WIDTH,8  *Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        if(itemManager.getHero().getCollisionsBounds(0,0).intersects(lava))
        {
            itemManager.getHero().SetX(Tile.TILE_WIDTH);
            itemManager.getHero().SetY(6*Tile.TILE_HEIGHT);
            itemManager.getHero().setLife(itemManager.getHero().getLife()-1);
            try{
                refLink.GetGame().getDB().updateHeroLife(refLink.GetMap().getItemManager().getHero().getLife());}
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            if(itemManager.getHero().getLife()<=0)
            {
                refLink.GetGame().loseState.SetAsCurrent();
            }
        }
    }

}
