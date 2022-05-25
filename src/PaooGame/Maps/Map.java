package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Text;
import PaooGame.Items.Hero;
import PaooGame.Items.ItemManager;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;
import PaooGame.Tiles.ElementManager;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public abstract class Map
{
    protected RefLinks refLink;   /*!< O referinte catre un obiect ce contine o serie de referinte utile in program.*/
    protected int width;          /*!< Latimea hartii in numar de dale.*/
    protected int height;         /*!< Inaltimea hartii in numar de dale.*/
    public int [][][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    protected ItemManager itemManager;
    protected ElementManager elementManager;

    protected BufferedImage background;

    private int spawnX, spawnY;


    protected ArrayList<Element> elementsToBeRefreshed;

    /*! \fn public Map(String[] paths, RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param paths fisierele din care se incarca mapa
        \param refLink O referinte catre un obiect ce contine o serie de referinte utile in program.
     */
    public Map(String[] paths, RefLinks links)
    {
        refLink = links;
        //incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.

        //ADAUGAM ENTITATILE------------------------------

        itemManager=new ItemManager(refLink,new Hero(refLink,0,0));


        //ADAUGAM ELEMENTE DIN INVENTAR------------------------------
        elementManager=new ElementManager(refLink);


        LoadWorld(paths);

        itemManager.getHero().SetX(spawnX);
        itemManager.getHero().SetY(spawnY);

        elementsToBeRefreshed=new ArrayList<Element>();

    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (Ex: a fost cules un totem)
     */
    public  void Update()
    {
        elementManager.Update();
        itemManager.Update();
    }

    public void Draw(Graphics g) //FUNCTIA CARE DESENEAZA DALELE
    {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva

        g.drawImage(background,0,0,null);


        for(int layer=0;layer<tiles.length;layer++)
        {
            for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
            {
                for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
                {
                    GetTile(layer,x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
                }
            }
        }

        //Items

        elementManager.Draw(g);
        itemManager.Draw(g);
        Text.drawString(g,"Vieti: " + itemManager.getHero().getLife() ,20,20,false,Color.white, Assets.font20);
        Text.drawString(g,"Scor: " + itemManager.getHero().getScore() ,100,20,false,Color.white, Assets.font20);
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de coordonate gresite etc se
        intoarce o dala predefinita
     */


    public Tile GetTile(int layer,int x, int y)
    {
        Tile t=null;
        if(x<0||y<0||x>=width||y>=height)
        {
            return Tile.piatra1;
        }
        try {
            t=Tile.tiles[tiles[layer][x][y]];
        } catch(Exception s){
            System.out.println("Dala ceruta nu a putut fi incarcata");
        }

        if(t==null)
            return Tile.soil1;
        return t;

    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
     */
    private void LoadWorld(String[] paths) {

        ///Se stabileste latimea hartii in numar de dale.
        ///Se stabileste inaltimea hartii in numar de dale
        ///Se construieste matricea de coduri de dale
        //Se incarca matricea cu coduri


        tiles = new int[paths.length][width][height];

        for (int layer = 0; layer < paths.length; layer++) {
            String file = Utils.loadFileAsString(paths[layer]);
            String[] tokens = file.split("\\s+");
            int readWidth = Utils.parseInt(tokens[0]);
            int readHeight = Utils.parseInt(tokens[1]);

            spawnX = Utils.parseInt(tokens[2]);
            spawnY = Utils.parseInt(tokens[3]);

            if(layer==0)
            {
                width=readWidth;
                height=readHeight;
                tiles=new int[paths.length][width][height];
            }
            else if(readWidth!=width||readHeight!=height){
                //
            }


            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++)
                    tiles[layer][x][y] = Utils.parseInt(tokens[(x + y * width) + 4]); //adaugam 4 deoarece avem deja 4 luate, alea de sus

        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public ElementManager getElementManager() {
        return elementManager;
    }

    public void setElementManager(ElementManager elementManager) {
        this.elementManager = elementManager;
    }

    public int getLayersNumber(){
        return tiles.length;
    }

    public void Refresh(){
        ArrayList<Element> list=elementManager.getElements();
        for(int i=0;i<elementsToBeRefreshed.size();i++) {
            boolean found=false;
            for(int j=0;j<list.size();j++)
                if(list.get(j).getX()==elementsToBeRefreshed.get(i).getX() && list.get(j).getY()==elementsToBeRefreshed.get(i).getY())
                    found=true;
            if(!found)
                elementManager.addElement(elementsToBeRefreshed.get(i).CreateNew(elementsToBeRefreshed.get(i).getX(),elementsToBeRefreshed.get(i).getY()));
        }
    }

}
