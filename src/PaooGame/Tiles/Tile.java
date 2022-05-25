package PaooGame.Tiles;

import PaooGame.Tiles.BushTiles.*;
import PaooGame.Tiles.Copac1Tiles.*;
import PaooGame.Tiles.FlowerTiles.FlowerTile;
import PaooGame.Tiles.GrassTiles.Grass1Tile;
import PaooGame.Tiles.IndicatoareTiles.IndicatorBidirectional;
import PaooGame.Tiles.IndicatoareTiles.IndicatorDreaptaTile;
import PaooGame.Tiles.Lvl2.Copac2Tiles.*;
import PaooGame.Tiles.Lvl2.Craniu.CraniuTile;
import PaooGame.Tiles.Lvl2.CristalTiles.*;
import PaooGame.Tiles.Lvl2.Cufar.CufarTile;
import PaooGame.Tiles.Lvl2.IarbaTiles.*;
import PaooGame.Tiles.Lvl2.IndicatorAdv;
import PaooGame.Tiles.Lvl2.LavaTiles.*;
import PaooGame.Tiles.Lvl2.Piatra2Tiles.*;
import PaooGame.Tiles.Lvl2.SolTiles.*;
import PaooGame.Tiles.Lvl2.TufisTiles.*;
import PaooGame.Tiles.Lvl3.*;
import PaooGame.Tiles.PamantTiles.*;
import PaooGame.Tiles.PiatraTiles.*;
import PaooGame.Tiles.ScaraTiles.*;
import PaooGame.Tiles.TotemTiles.TotemTile;
import PaooGame.Tiles.TransparentTiles.TransparentTile;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 256;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

    public static Tile TransparentTile = new TransparentTile(0);

    public static Tile copacel1Tile = new copacel1Tile(1);
    public static Tile copacel2Tile = new copacel2Tile(2);
    public static Tile copacel3Tile = new copacel3Tile(3);
    public static Tile copacel4Tile = new copacel4Tile(4);

    public static Tile copacel5Tile = new copacel5Tile(5);
    public static Tile copacel6Tile = new copacel6Tile(6);
    public static Tile copacel7Tile = new copacel7Tile(7);
    public static Tile copacel8Tile = new copacel8Tile(8);

    public static Tile soil1 = new Pamant1SolidTile(9);
    public static Tile soil2 = new Pamant2SolidTile(10);
    public static Tile soil3 = new Pamant3SolidTile(11);
    public static Tile soil4 = new Pamant4Tile(12);
    public static Tile soil5 = new Pamant5Tile(13);
    public static Tile soil6 = new Pamant6Tile(14);
    public static Tile soil7 = new Pamant7Tile(15);
    public static Tile soil8 = new Pamant8Tile(16);
    public static Tile soil9 = new Pamant9Tile(17);

    public static Tile sign = new IndicatorDreaptaTile(18);

    public static Tile scara1 = new Scara1Tile(19);
    public static Tile scara2 = new Scara2Tile(20);
    public static Tile scara3 = new Scara3Tile(21);

    public static Tile flower = new FlowerTile(22);
    public static Tile pers = new PpersTile(23);

    public static Tile bush1 = new Bush1Tile(24);
    public static Tile bush2 = new Bush2Tile(25);

    public static Tile grass1 = new Grass1Tile(26);
    public static Tile piatra1 = new Piatra1Tile(27);
    public static Tile piatra2 = new Piatra2Tile(28);

    public static Tile soil10 = new Pamant10Tile(29);
    public static Tile totem = new TotemTile(30);

    public static Tile sign2 = new IndicatorBidirectional(31);

    public static Tile sol1 = new Sol1SolidTile(32);
    public static Tile sol2 = new Sol2SolidTile(33);
    public static Tile sol3 = new Sol3SolidTile(34);
    public static Tile sol4 = new Sol4Tile(35);
    public static Tile sol5 = new Sol5Tile(36);
    public static Tile sol6 = new Sol6Tile(37);
    public static Tile sol7 = new Sol7Tile(38);
    public static Tile sol8 = new Sol8Tile(39);
    public static Tile sol9 = new Sol9Tile(40);

    public static Tile land1 = new Land1SolidTile(41);
    public static Tile land2 = new Land2SolidTile(42);
    public static Tile land3 = new Land3SolidTile(43);

    public static Tile copac1 = new Cop1Tile(44);
    public static Tile copac2 = new Cop2Tile(45);
    public static Tile copac3 = new Cop3Tile(46);
    public static Tile copac4 = new Cop4Tile(47);
    public static Tile copac5 = new Cop5Tile(48);
    public static Tile copac6 = new Cop6Tile(49);
    public static Tile copac7 = new Cop7Tile(50);
    public static Tile copac8 = new Cop8Tile(51);

    public static Tile lava1 = new Lava1Tile(52);
    public static Tile lava2 = new Lava2Tile(53);

    public static Tile tufis1 = new Tufis1Tile(54);
    public static Tile tufis2 = new Tufis2Tile(55);

    public static Tile piatra3 = new Piatra3SolidTile(56);
    public static Tile piatra4 = new Piatra4SolidTile(57);

    public static Tile iarba1 = new Iarba1Tile(58);
    public static Tile iarba2 = new Iarba2Tile(59);

    public static Tile semn = new IndicatorAdv(60);
    public static Tile cufar = new CufarTile(61);
    public static Tile craniu = new CraniuTile(62);
    public static Tile cristal= new CristalTile(63);
    public static Tile bluecristal = new BlueCristalTile(64);

    public static Tile podea1 = new Podea1Tile(65);
    public static Tile podea2 = new Podea2Tile(66);

    public static Tile castel1= new Castel1Tile(67);
    public static Tile castel2 = new Castel2Tile(68);
    public static Tile castel3 = new Castel3Tile(69);
    public static Tile castel4 = new Castel4Tile(70);
    public static Tile castel5 = new Castel5Tile(71);
    public static Tile castel6 = new Castel6Tile(72);
    public static Tile castel7 = new Castel7Tile(73);
    public static Tile castel8 = new Castel8Tile(74);

    public static Tile cutie = new CutieTile(75);
    public static Tile cristalroz = new CristalRoz(76);



    public static final int TILE_WIDTH  = 48;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 48;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
    public boolean OnLadder(){return false;}
}
