package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Monsters.Schelet;
import PaooGame.Items.NPC.*;
import PaooGame.RefLinks;
import PaooGame.States.LoseState;
import PaooGame.States.State;
import PaooGame.StaticItem.Cufar;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.sql.SQLException;

public class Map5 extends Map{

    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel3_1.txt"
    };

    public Map5( RefLinks links) {
        super(paths, links);
        background= ImageLoader.LoadImage("/textures/Background3.png");

        itemManager.addItem((new Merlin(refLink,15*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT)));
        itemManager.addItem((new Schelet(refLink,9*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT)));

        itemManager.addItem((new Cufar(refLink,2*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT)));
        elementsToBeRefreshed.add(Element.totem.CreateNew(0*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(1*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(11*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(5*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(6*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(9*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(13*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));

        Refresh();
    }

    @Override
    public void Update()
    {
        super.Update();
        Rectangle lava=new Rectangle(10*Tile.TILE_WIDTH,8 * Tile.TILE_HEIGHT,2*Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
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

