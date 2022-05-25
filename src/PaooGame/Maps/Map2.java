package PaooGame.Maps;

import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Monsters.Monster_green;
import PaooGame.RefLinks;
import PaooGame.StaticItem.Cufar;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.Tile;

public class Map2 extends Map{
    private static final String[] paths = new String[] {
            "res/Mapa/MapaLevel1_3.txt",
            "res/Mapa/MapaLevel1_4.txt",
            "res/Mapa/MapaLevel1_5.txt"
    };
    public Map2(RefLinks links) {


        super(paths, links);
        background= ImageLoader.LoadImage("/textures/Background1.png");


        itemManager.addItem((new Cufar(refLink,0,0)));
        elementsToBeRefreshed.add(Element.totem.CreateNew(5*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(7*Tile.TILE_WIDTH,5*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(11*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(13*Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT));

        elementsToBeRefreshed.add(Element.totem.CreateNew(3*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(4*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(6*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(9*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(11*Tile.TILE_WIDTH,2*Tile.TILE_HEIGHT));
        elementsToBeRefreshed.add(Element.totem.CreateNew(12*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT));
        itemManager.addItem((new Monster_green(refLink,13*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT)));
        Refresh();

    }
}
