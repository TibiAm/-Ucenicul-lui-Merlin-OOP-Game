package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.NPC.Elisyum;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

public class Map1 extends Map {
    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel1.txt",
            "res/Mapa/MapaLevel1_2.txt"
    };
    public Map1(RefLinks links){


        super(paths, links);
        background= ImageLoader.LoadImage("/textures/Background1.png");



        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(5*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(7*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(7*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(1*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(5*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(9*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(11*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(13*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));

        itemManager.addItem(new Elisyum(refLink,10*Tile.TILE_WIDTH,4*Tile.TILE_HEIGHT));
        Refresh();

    }
}
